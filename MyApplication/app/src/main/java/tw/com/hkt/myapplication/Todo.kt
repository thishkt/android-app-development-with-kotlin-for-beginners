package tw.com.hkt.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Long =0,
    val title: String,
    val description: String,
    val isCompleted: Boolean =false
)


