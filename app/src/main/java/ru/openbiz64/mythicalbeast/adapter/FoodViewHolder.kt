package ru.openbiz64.mythicalbeast.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.openbiz64.mythicalbeast.FoodModel
import ru.openbiz64.mythicalbeast.R

class FoodViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    fun bind(food: FoodModel) {

        val tvTitle = root.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = root.findViewById<TextView>(R.id.tvDescription)
        val tvCalories = root.findViewById<TextView>(R.id.tvCalories)
        val tvRate = root.findViewById<TextView>(R.id.tvRate)
        val ivFood = root.findViewById<ImageView>(R.id.ivFood)


        tvTitle.text = food.title
        tvDescription.text = food.description
        tvCalories.text = food.calories
        tvRate.text = food.rate
        ivFood.setImageResource(food.imgId)
    }
}