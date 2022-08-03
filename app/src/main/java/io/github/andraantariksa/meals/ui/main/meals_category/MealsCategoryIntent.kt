package io.github.andraantariksa.meals.ui.main.meals_category

sealed class MealsCategoryIntent {
    class FetchMeals(val id: String) : MealsCategoryIntent()
}