package io.github.andraantariksa.meal.core.data.repository

import io.github.andraantariksa.meal.core.data.data_source_store.local.data_source.MealsLocalDataSource
import io.github.andraantariksa.meal.core.data.data_source_store.local.data_source.MealsRemoteDataSource
import io.github.andraantariksa.meal.core.domain.entity.Category
import io.github.andraantariksa.meal.core.domain.entity.Meal
import io.github.andraantariksa.meal.core.domain.repository.MealsRepository
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val remoteDataSource: MealsRemoteDataSource,
    private val localDataSource: MealsLocalDataSource
) : MealsRepository {
    override suspend fun getCategoryMeals(id: String): Result<List<Meal>> {
        return Result.success(remoteDataSource.filterByCategories(id))
    }

    override suspend fun search(name: String): Result<List<Meal>> {
        return Result.success(remoteDataSource.search(name))
    }

    override suspend fun getCategories(): Result<List<Category>> {
        return Result.success(remoteDataSource.getCategories())
    }
}