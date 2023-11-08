package tw.com.hkt.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class DemoFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val name = arguments?.getString("name")
        val age = arguments?.getInt("age")

        Toast.makeText(context,"$name , $age ",Toast.LENGTH_LONG).show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_demo, container, false)
    }
}