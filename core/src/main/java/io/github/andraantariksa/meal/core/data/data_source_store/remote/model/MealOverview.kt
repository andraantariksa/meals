package io.github.andraantariksa.meal.core.data.data_source_store.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MealOverview(
    @Json(name = "idMeal")
    val idMeal: String,
    @Json(name = "strMeal")
    val strMeal: String,
    @Json(name = "strMealThumb")
    val strMealThumb: String
) : io.github.andraantariksa.meal.core.domain.entity.MealOverview(
    id = idMeal.toInt(),
    name = strMeal,
    thumbnail = strMealThumb
)