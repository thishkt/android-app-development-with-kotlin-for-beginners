package tw.com.hkt.myapplication

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tw.com.hkt.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myTextView.text ="HKT線上教室"
        binding.myTextView.textSize = 50f
        binding.myTextView.setTextColor(Color.parseColor("#2828ff"))
        binding.myTextView.setTypeface(null, Typeface.BOLD_ITALIC)
    }
}