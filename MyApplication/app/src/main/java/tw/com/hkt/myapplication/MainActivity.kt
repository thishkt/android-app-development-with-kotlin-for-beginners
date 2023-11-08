package tw.com.hkt.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import tw.com.hkt.myapplication.databinding.ActivityMainBinding

class MainActivity : FragmentActivity(),
    DemoFragment.DemoListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onButtonClick(text: String) {
        Log.d("QQQ", "onButtonClick $text")
        binding.tvResult.text = text
    }

}