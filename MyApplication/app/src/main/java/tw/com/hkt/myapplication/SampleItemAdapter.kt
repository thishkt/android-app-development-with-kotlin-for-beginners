package tw.com.hkt.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tw.com.hkt.myapplication.databinding.ItemListBinding

class SampleItemAdapter(private val items: List<SampleItem>) : RecyclerView.Adapter<SampleItemAdapter.ViewHolder>() {

    private var itemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = items[position]
                    itemClickListener?.onItemClick(item)
                }
            }
        }

        fun bind(item: SampleItem) {
            binding.itemTitle.text = item.title
            binding.itemDesc.text = item.description
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(item: SampleItem)
    }
}