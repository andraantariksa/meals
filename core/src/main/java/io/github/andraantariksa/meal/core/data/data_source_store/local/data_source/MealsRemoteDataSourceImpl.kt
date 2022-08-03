package io.github.andraantariksa.meal.core.data.data_source_store.local.data_source

import io.github.andraantariksa.meal.core.data.data_source_store.remote.MealsService
import io.github.andraantariksa.meal.core.domain.entity.Category
import io.github.andraantariksa.meal.core.domain.entity.Meal
import javax.inject.Inject

class MealsRemoteDataSourceImpl @Inject constructor(private val mealsService: MealsService) :
    MealsRemoteDataSource {
    override suspend fun getCategories(): List<Category> {
        return mealsService.getCategories().categories
    }

    override suspend fun filterByCategories(category: String): List<Meal> {
        return mealsService.filterByCategories(category).meals
    }

    override suspend fun search(name: String): List<Meal> {
        return mealsService.search(name).meals
    }
}