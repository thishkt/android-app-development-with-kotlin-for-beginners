package tw.com.hkt.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import tw.com.hkt.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jsonString = intent.getStringExtra(MainActivity.TRANSFER_DATA)
        displayTransferData(jsonString)

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun displayTransferData(jsonString: String?) {
        jsonString?.let {
            val transfer = Gson().fromJson(it, Transfer::class.java)
            with(binding) {
                tvTxId.text = transfer?.id ?: ""
                tvFromAccountId.text = transfer?.fromAccountId?.toString() ?: ""
                tvToAccountId.text = transfer?.toAccountId?.toString() ?: ""
                tvAmount.text = transfer?.amount?.toString() ?: ""
                tvCreatedAt.text = transfer?.createdAt ?: ""
            }
        }
    }
}