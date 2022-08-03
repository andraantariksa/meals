package io.github.andraantariksa.meal.core.data.data_source_store.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Categories(
    @Json(name = "categories")
    val categories: List<Category>
)