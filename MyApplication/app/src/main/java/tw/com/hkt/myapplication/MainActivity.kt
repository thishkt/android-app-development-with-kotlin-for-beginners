package tw.com.hkt.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tw.com.hkt.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val demoFragment = DemoFragment().apply {
            arguments = Bundle().apply {
                putString("name", "John")
                putInt("age", 25)
            }
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.demoFragment, demoFragment)
            .commit()

    }
}