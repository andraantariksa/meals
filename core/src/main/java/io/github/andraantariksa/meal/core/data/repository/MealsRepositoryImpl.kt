package io.github.andraantariksa.meal.core.data.repository

import io.github.andraantariksa.meal.core.data.data_source_store.local.MealsLocalDataSource
import io.github.andraantariksa.meal.core.data.data_source_store.remote.MealsRemoteDataSource
import io.github.andraantariksa.meal.core.domain.entity.Category
import io.github.andraantariksa.meal.core.domain.entity.Meal
import io.github.andraantariksa.meal.core.domain.entity.MealOverview
import io.github.andraantariksa.meal.core.domain.repository.MealsRepository
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val remoteDataSource: MealsRemoteDataSource,
    private val localDataSource: MealsLocalDataSource
) : MealsRepository {
    override suspend fun getCategoryMeals(id: String): Result<List<MealOverview>> {
        return Result.success(remoteDataSource.filterByCategories(id))
    }

    override suspend fun search(name: String): Result<List<Meal>> {
        return Result.success(remoteDataSource.search(name))
    }

    override suspend fun getCategories(): Result<List<Category>> {
        return Result.success(remoteDataSource.getCategories())
    }

    override suspend fun getMeal(id: Int): Result<Meal> {
        return Result.success(remoteDataSource.getMeal(id))
    }
}