package io.github.andraantariksa.meals.ui.main.meals_category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import io.github.andraantariksa.meal.core.domain.entity.MealOverview
import io.github.andraantariksa.meals.databinding.MealItemBinding

class MealsCategoryAdapter(
    private val mealOverviews: List<MealOverview>,
    private val onClick: ((MealOverview) -> Unit)? = null
) :
    RecyclerView.Adapter<MealsCategoryAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: MealItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MealItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = mealOverviews[position]
        holder.binding.apply {
            onClick?.let { onClick ->
                root.setOnClickListener {
                    onClick(meal)
                }
            }
            textViewMealName.text = meal.name
            imageViewMealThumbnail.load("${meal.thumbnail}/preview")
        }
    }

    override fun getItemCount(): Int = mealOverviews.size
}