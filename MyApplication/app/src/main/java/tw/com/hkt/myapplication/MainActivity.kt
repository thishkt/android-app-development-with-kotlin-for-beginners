package tw.com.hkt.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import tw.com.hkt.myapplication.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getNetData()
    }

    private fun getNetData() {
        // 建立一個 OkHttp 的客戶端物件
        val client = OkHttpClient()

        // 建立一個請求物件，指定 URL 和方法
        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts")
            .get()
            .build()

        // 使用 enqueue 方法非同步地執行請求，並提供一個回呼函數
        client.newCall(request).enqueue(object : Callback {
            // 當請求失敗時，顯示錯誤訊息
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Log.d("HKT", "Error: ${e.message}")
            }

            // 當請求成功時，將回應的 JSON 字串設定給 TextView
            override fun onResponse(call: okhttp3.Call, response: Response) {
                val json = response.body?.string()
                Log.d("HKT", "$json")
            }
        })
    }
}