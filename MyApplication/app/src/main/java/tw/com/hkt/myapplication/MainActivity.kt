package tw.com.hkt.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tw.com.hkt.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // 創建一個View Binding變數
    private val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
    private val dao: TodoDao by lazy { database.todoDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) // 使用View Binding初始化佈局
        setContentView(binding.root)

        // 查詢按鈕點擊事件處理
        binding.queryButton.setOnClickListener {
            queryTodos()
        }

        // 新增按鈕點擊事件處理
        binding.addButton.setOnClickListener {
            insertTodo()
        }

        // 更新按鈕點擊事件處理
        binding.updateButton.setOnClickListener {
            updateTodo()
        }

        // 刪除按鈕點擊事件處理
        binding.deleteButton.setOnClickListener {
            deleteTodo()
        }
    }

    private fun insertTodo() {
        val newTodo = Todo(
            title = "新任務",
            description = "這是一筆新的任務",
            isCompleted = false
        )
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertTodo(newTodo)
        }
    }

    private fun queryTodos() {
        CoroutineScope(Dispatchers.IO).launch {
            val todos = dao.getAllTodos()
            if (todos.isEmpty()) {
                Log.d("HKT", "沒有任何資料")
            } else {
                todos.forEach { todo ->
                    val todoText =
                        "ID: ${todo.id}, Title: ${todo.title}, Description: ${todo.description}, Completed: ${todo.isCompleted}\n"
                    Log.d("HKT", todoText)
                }
            }
        }
    }

    private fun updateTodo() {
        val updatedTodo = Todo(
            id = 1,
            title = "更新後的任務",
            description = "這是更新後的任務",
            isCompleted = true
        )

        CoroutineScope(Dispatchers.IO).launch {
            dao.updateTodo(updatedTodo)
        }
    }

    private fun deleteTodo() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteTodo(id = 1)
        }
    }
}