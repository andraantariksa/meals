package io.github.andraantariksa.meals.ui.main.meal

sealed class MealIntent {
    class FetchMeal(val id: Int): MealIntent()
}