package tw.com.hkt.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import tw.com.hkt.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val TRANSFER_DATA = "transfer_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener{
            val transfer = Transfer(
                id = "TX8437858372101",
                fromAccountId = 66612345678,
                toAccountId = 66612345777,
                amount = 100.00,
                createdAt = "2077/08/14"
            )
            val jsonString = Gson().toJson(transfer)

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(TRANSFER_DATA, jsonString)
            startActivity(intent)
        }
    }
}