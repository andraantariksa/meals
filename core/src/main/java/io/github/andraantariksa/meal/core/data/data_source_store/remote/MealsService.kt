package io.github.andraantariksa.meal.core.data.data_source_store.remote

import io.github.andraantariksa.meal.core.data.data_source_store.remote.model.Categories
import io.github.andraantariksa.meal.core.data.data_source_store.remote.model.Meals
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsService {
    @GET("search.php")
    suspend fun search(@Query("s") name: String): Meals

    @GET("search.php")
    suspend fun listByLetter(@Query("f") letter: Char): Meals

    @GET("lookup.php")
    suspend fun getDetail(@Query("i") id: Int): Meals

    @GET("random.php")
    suspend fun getRandom(): Meals

    @GET("filter.php")
    suspend fun filterByCategories(@Query("c") category: String): Meals

    @GET("filter.php")
    suspend fun filterByArea(@Query("a") area: String): Meals

    @GET("categories.php")
    suspend fun getCategories(): Categories
}