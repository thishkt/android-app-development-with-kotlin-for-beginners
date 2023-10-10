package tw.com.hkt.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tw.com.hkt.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputData = intent.getStringExtra(MainActivity.DATA_KEY)
        binding.tvShowData.text = inputData

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}
