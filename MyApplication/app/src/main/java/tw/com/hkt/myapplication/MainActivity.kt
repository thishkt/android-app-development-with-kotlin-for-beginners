package tw.com.hkt.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import tw.com.hkt.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),SampleItemAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = generateFakeData(100) // 生成一百筆假資料

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = SampleItemAdapter(items)
        adapter.setOnItemClickListener(this)
        recyclerView.adapter = adapter
    }

    // 生成假資料的函數
    private fun generateFakeData(count: Int): List<SampleItem> {
        val fakeData = mutableListOf<SampleItem>()
        for (i in 1..count) {
            fakeData.add(SampleItem("項目 $i", "這是項目 $i 的描述"))
        }
        return fakeData
    }


    override fun onItemClick(item: SampleItem) {
        val toastText = "標題: ${item.title}\n內容: ${item.description}"
        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show()
    }
}