package tw.com.hkt.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tw.com.hkt.myapplication.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val DATA_KEY = "data_key"
        fun startWithData(context: Context, data: String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(DATA_KEY, data)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputData = intent.getStringExtra(DATA_KEY)
        binding.tvShowData.text = inputData

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}
