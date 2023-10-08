package tw.com.hkt.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import tw.com.hkt.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myButton.setOnClickListener {
            val inputData = binding.myEditText.text.toString()
            if (inputData.isEmpty()) {
                Toast.makeText(this, "尚未輸入任何資料", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, inputData, Toast.LENGTH_SHORT).show()
            }
        }

    }
}