package io.github.andraantariksa.meals.ui.main.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import io.github.andraantariksa.meal.core.domain.entity.Meal
import io.github.andraantariksa.meals.databinding.MealItemBinding

class SearchedMealsAdapter(
    private val mealOverviews: List<Meal>,
    private val onClick: ((Meal) -> Unit)? = null
) :
    RecyclerView.Adapter<SearchedMealsAdapter.ViewHolder>() {
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