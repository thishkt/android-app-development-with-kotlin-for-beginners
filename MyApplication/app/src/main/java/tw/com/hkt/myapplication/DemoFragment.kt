package tw.com.hkt.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tw.com.hkt.myapplication.databinding.FragmentDemoBinding

class DemoFragment : Fragment() {

    private lateinit var binding: FragmentDemoBinding
    private var activityCallback: DemoListener? = null

    interface DemoListener {
        fun onButtonClick(text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as DemoListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString()
                    + " must implement ToolbarListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDemoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button1.setOnClickListener { buttonClicked("按鈕一") }
        binding.button2.setOnClickListener { buttonClicked("按鈕二") }
        binding.button3.setOnClickListener { buttonClicked("按鈕三") }
    }

    private fun buttonClicked(data: String) {
        activityCallback?.onButtonClick("你點擊了： $data")
    }
}