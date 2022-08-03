package io.github.andraantariksa.meal.core.data.data_source_store.remote

import io.github.andraantariksa.meal.core.domain.entity.Category
import io.github.andraantariksa.meal.core.domain.entity.Meal
import io.github.andraantariksa.meal.core.domain.entity.MealOverview


interface MealsRemoteDataSource {
    suspend fun getCategories(): List<Category>
    suspend fun filterByCategories(category: String): List<MealOverview>
    suspend fun search(name: String): List<Meal>
    suspend fun getMeal(id: Int): Meal
}