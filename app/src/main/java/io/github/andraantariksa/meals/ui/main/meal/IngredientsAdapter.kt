package io.github.andraantariksa.meals.ui.main.meal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.andraantariksa.meals.databinding.IngrendientItemBinding

class IngredientsAdapter(
    private val ingredients: List<Pair<String, String>>
) :
    RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: IngrendientItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = IngrendientItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ingredient = ingredients[position]
        holder.binding.apply {
            textViewIngredient.text = "${ingredient.first} - ${ingredient.second}"
        }
    }

    override fun getItemCount(): Int = ingredients.size
}
