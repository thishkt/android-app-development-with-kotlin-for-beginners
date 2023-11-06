package tw.com.hkt.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    // 定義一個可觀察的計數器變數
    val counter = MutableLiveData<Int>()

    // 初始化計數器的值為 0
    init {
        counter.value = 0
    }

    // 定義一個增加計數器的方法
    fun increment() {
        counter.value = counter.value?.plus(1)
    }

    // 定義一個減少計數器的方法
    fun decrement() {
        counter.value = counter.value?.minus(1)
    }
}