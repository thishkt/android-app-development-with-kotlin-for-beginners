package tw.com.hkt.myapplication

data class Transfer(
    val id: String, //交易 ID
    val fromAccountId: Long, //轉帳來源 ID
    val toAccountId: Long, //轉帳目標 ID
    val amount: Double, //轉帳金額
    val createdAt: String //轉帳時間
)