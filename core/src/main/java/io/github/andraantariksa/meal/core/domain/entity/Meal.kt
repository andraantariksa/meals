package io.github.andraantariksa.meal.core.domain.entity

open class Meal(
    val area: String,
    val category: String,
    val id: Int,
    val name: String,
    val ingredients: List<Pair<String, String>>,
    val thumbnail: String,
    val instructions: String,
    val youtubeId: String?,
)