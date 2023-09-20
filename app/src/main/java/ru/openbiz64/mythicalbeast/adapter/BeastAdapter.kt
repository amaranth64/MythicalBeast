package ru.openbiz64.mythicalbeast.adapter

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import ru.openbiz64.mythicalbeast.dataclass.BeastDataClass
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.openbiz64.mythicalbeast.R
import ru.openbiz64.mythicalbeast.databinding.ItemFoodBinding
import java.io.IOException

class BeastAdapter(private var listener: Listener, private val context: Context): ListAdapter<BeastDataClass, BeastAdapter.ItemHolder>(ItemComparator()) {

    class ItemHolder(view: View, private val context: Context): RecyclerView.ViewHolder(view){
        var binding = ItemFoodBinding.bind(view)

        fun setData(item: BeastDataClass, listener: Listener) = with(binding){
            tvTitle.text = item.title
            tvDescription.text = item.mythology
            tvCalories.text = item.id.toString()
            tvRate.text = item.id.toString()
            //ivFood.setImageResource(item.imgId)

            try {
                val inputStream = context.assets.open("image/" + item.picUrl + ".jpg")
                val bmp = BitmapDrawable.createFromStream(inputStream, null)?.toBitmap()
                ivFood.setImageBitmap(bmp)
            } catch (e: IOException) {
                Toast.makeText(context, "File not found", Toast.LENGTH_LONG).show()
            }

            itemView.setOnClickListener {
                listener.onClick(item)
            }
        }

        companion object{
            fun create(parent: ViewGroup, context: Context): ItemHolder{
                return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false), context)
            }
        }

    }

    class ItemComparator: DiffUtil.ItemCallback<BeastDataClass>(){
        override fun areItemsTheSame(oldItem: BeastDataClass, newItem: BeastDataClass): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BeastDataClass, newItem: BeastDataClass): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent, context)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position), listener)
    }

    interface Listener{
        fun onClick(item: BeastDataClass)
    }
}