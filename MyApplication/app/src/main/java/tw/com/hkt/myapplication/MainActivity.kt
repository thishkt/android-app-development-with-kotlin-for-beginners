package tw.com.hkt.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import tw.com.hkt.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dataStore by preferencesDataStore("my_preferences")

    companion object {
        val COUNT_KEY = intPreferencesKey("count_key")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCount()
        setupAddButton()
    }


    private fun setupCount() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                val countFlow = dataStore.data.map { prefs ->
                    prefs[COUNT_KEY] ?: 0
                }

                countFlow.collect { count ->
                    binding.tvCount.text = count.toString()
                }
            }
        }
    }

    private fun setupAddButton() {
        binding.btnAdd.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                dataStore.edit { prefs ->
                    val currentCount = prefs[COUNT_KEY] ?: 0
                    prefs[COUNT_KEY] = currentCount + 1
                }
            }
        }
    }
}