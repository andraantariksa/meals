package io.github.andraantariksa.meal.core.data.data_source_store.local.data_source

import io.github.andraantariksa.meal.core.domain.entity.Category
import io.github.andraantariksa.meal.core.domain.entity.Meal


interface MealsRemoteDataSource {
    suspend fun getCategories(): List<Category>
    suspend fun filterByCategories(category: String): List<Meal>
    suspend fun search(name: String): List<Meal>
}