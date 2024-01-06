package tw.com.hkt.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tw.com.hkt.myapplication.databinding.ActivityMainBinding
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var processTextView: TextView
    private lateinit var resultTextView: TextView
    private var processText = ""
    private var isFirstInput = true
    private var isCalculated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        processTextView = binding.processTextView
        resultTextView = binding.resultTextView

        val buttons = listOf(
            binding.button0,
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9,
            binding.buttonAllClear,
            binding.buttonToggleSign,
            binding.buttonDivide,
            binding.buttonBackspace,
            binding.buttonMultiply,
            binding.buttonMinus,
            binding.buttonPlus,
            binding.buttonEquals,
            binding.buttonDot
        )

        buttons.forEach { button ->
            button.setOnClickListener { onButtonClick(button) }
        }
    }

    private fun onButtonClick(button: View) {
        val buttonText = (button as Button).text.toString()

        if (isCalculated && buttonText in "0".."9") {
            processText = ""
            processTextView.text = ""
            resultTextView.text = ""
            isFirstInput = true
            isCalculated = false
        }

        when (buttonText) {
            "AC" -> {
                processText = ""
                processTextView.text = ""
                resultTextView.text = ""
                isFirstInput = true
                isCalculated = false
            }

            "=" -> {
                if (!isFirstInput) {
                    val result = evaluate(processText)
                    // 格式化結果以去除不必要的小數點
                    resultTextView.text = if (result.contains(".0")) {
                        result.dropLast(2)
                    } else {
                        result
                    }
                    isCalculated = true
                }
            }

            "+/-" -> {
                if (processText.isNotEmpty() && processText.toDoubleOrNull() != null && processText.toDouble() != 0.0) {
                    processText = if (processText.startsWith("-")) {
                        processText.drop(1)
                    } else {
                        "-$processText"
                    }
                    processTextView.text = processText
                }
            }

            "⌫" -> {
                if (processText.isNotEmpty()) {
                    processText = processText.dropLast(1)
                    processTextView.text = processText
                }
            }

            "." -> {
                if (!processText.endsWith(".") && !processText.contains(" .") && !processText.endsWith(
                        " "
                    )
                ) {
                    processText += if (isFirstInput || processText.last()
                            .isWhitespace()
                    ) "0" else ""
                    processText += buttonText
                    processTextView.text = processText
                    isFirstInput = false
                }
            }

            else -> {
                if (buttonText in listOf("+", "-", "*", "/")) {
                    if (!isFirstInput && !processText.endsWith(" ")) {
                        processText += " $buttonText "
                        processTextView.text = processText
                        isFirstInput = true
                    }
                } else {
                    processText += buttonText
                    processTextView.text = processText
                    isFirstInput = false
                }
            }
        }
    }

    private fun evaluate(process: String): String {
        return try {
            val parts = process.split(" ")
            var result = parts[0].toDouble()
            var i = 1
            while (i < parts.size) {
                val operator = parts[i]
                val nextNumber = parts[i + 1].toDouble()
                when (operator) {
                    "+" -> result += nextNumber
                    "-" -> result -= nextNumber
                    "*" -> result *= nextNumber
                    "/" -> result /= nextNumber
                }
                i += 2
            }
            // 檢查結果是否為整數，並相應地格式化輸出
            if (result % 1.0 == 0.0) {
                result.toInt().toString()
            } else {
                result.toString()
            }
        } catch (e: Exception) {
            "Error" // 錯誤時返回 "Error"
        }
    }
}