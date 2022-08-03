package io.github.andraantariksa.meal.core.domain.repository

import io.github.andraantariksa.meal.core.domain.entity.Category
import io.github.andraantariksa.meal.core.domain.entity.Meal

interface MealsRepository {
    suspend fun search(name: String): Result<List<Meal>>
    suspend fun getCategoryMeals(id: String): Result<List<Meal>>
    suspend fun getCategories(): Result<List<Category>>
}