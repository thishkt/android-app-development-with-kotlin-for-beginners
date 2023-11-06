package tw.com.hkt.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import tw.com.hkt.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 宣告一個計數器的 ViewMode 變數
    private lateinit var counterViewModel: CounterViewModel

    // 宣告一個 view binding 的變數
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 透過綁定類別的 inflate 方法來建立 view binding 的實例
        binding = ActivityMainBinding.inflate(layoutInflater)
        // 取得根視圖的引用
        val view = binding.root
        // 將根視圖設定為活動視圖
        setContentView(view)

        // 透過 ViewModelProvider 來取得計數器的 ViewMode 實例
        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        // 為增加按鈕設定點擊事件的監聽器
        binding.incrementButton.setOnClickListener {
            // 呼叫 ViewMode 的增加方法
            counterViewModel.increment()
        }

        // 為減少按鈕設定點擊事件的監聽器
        binding.decrementButton.setOnClickListener {
            // 呼叫 viewmodel 的減少方法
            counterViewModel.decrement()
        }

        // 為計數器變數設定觀察者
        counterViewModel.counter.observe(this) { value ->
            // 將計數器的值顯示在文字元件上
            binding.counterText.text = value.toString()
        }
    }
}