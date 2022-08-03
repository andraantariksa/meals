package io.github.andraantariksa.meal.core.domain.repository

import io.github.andraantariksa.meal.core.domain.entity.Category
import io.github.andraantariksa.meal.core.domain.entity.Meal
import io.github.andraantariksa.meal.core.domain.entity.MealOverview

interface MealsRepository {
    suspend fun search(name: String): Result<List<Meal>>
    suspend fun getCategoryMeals(id: String): Result<List<MealOverview>>
    suspend fun getCategories(): Result<List<Category>>
    suspend fun getMeal(id: Int): Result<Meal>
}