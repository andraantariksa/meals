package io.github.andraantariksa.meal.core.data.data_source_store.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meal(
    @Json(name = "dateModified")
    val dateModified: Any,
    @Json(name = "idMeal")
    val idMeal: String,
    @Json(name = "strArea")
    val strArea: String,
    @Json(name = "strCategory")
    val strCategory: String,
    @Json(name = "strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: Any,
    @Json(name = "strDrinkAlternate")
    val strDrinkAlternate: Any,
    @Json(name = "strImageSource")
    val strImageSource: Any,
    @Json(name = "strIngredient1")
    val strIngredient1: String?,
    @Json(name = "strIngredient10")
    val strIngredient10: String?,
    @Json(name = "strIngredient11")
    val strIngredient11: String?,
    @Json(name = "strIngredient12")
    val strIngredient12: String?,
    @Json(name = "strIngredient13")
    val strIngredient13: String?,
    @Json(name = "strIngredient14")
    val strIngredient14: String?,
    @Json(name = "strIngredient15")
    val strIngredient15: String?,
    @Json(name = "strIngredient16")
    val strIngredient16: String?,
    @Json(name = "strIngredient17")
    val strIngredient17: String?,
    @Json(name = "strIngredient18")
    val strIngredient18: String?,
    @Json(name = "strIngredient19")
    val strIngredient19: String?,
    @Json(name = "strIngredient2")
    val strIngredient2: String?,
    @Json(name = "strIngredient20")
    val strIngredient20: String?,
    @Json(name = "strIngredient3")
    val strIngredient3: String?,
    @Json(name = "strIngredient4")
    val strIngredient4: String?,
    @Json(name = "strIngredient5")
    val strIngredient5: String?,
    @Json(name = "strIngredient6")
    val strIngredient6: String?,
    @Json(name = "strIngredient7")
    val strIngredient7: String?,
    @Json(name = "strIngredient8")
    val strIngredient8: String?,
    @Json(name = "strIngredient9")
    val strIngredient9: String?,
    @Json(name = "strInstructions")
    val strInstructions: String,
    @Json(name = "strMeal")
    val strMeal: String,
    @Json(name = "strMealThumb")
    val strMealThumb: String,
    @Json(name = "strMeasure1")
    val strMeasure1: String?,
    @Json(name = "strMeasure10")
    val strMeasure10: String?,
    @Json(name = "strMeasure11")
    val strMeasure11: String?,
    @Json(name = "strMeasure12")
    val strMeasure12: String?,
    @Json(name = "strMeasure13")
    val strMeasure13: String?,
    @Json(name = "strMeasure14")
    val strMeasure14: String?,
    @Json(name = "strMeasure15")
    val strMeasure15: String?,
    @Json(name = "strMeasure16")
    val strMeasure16: String?,
    @Json(name = "strMeasure17")
    val strMeasure17: String?,
    @Json(name = "strMeasure18")
    val strMeasure18: String?,
    @Json(name = "strMeasure19")
    val strMeasure19: String?,
    @Json(name = "strMeasure2")
    val strMeasure2: String?,
    @Json(name = "strMeasure20")
    val strMeasure20: String?,
    @Json(name = "strMeasure3")
    val strMeasure3: String?,
    @Json(name = "strMeasure4")
    val strMeasure4: String?,
    @Json(name = "strMeasure5")
    val strMeasure5: String?,
    @Json(name = "strMeasure6")
    val strMeasure6: String?,
    @Json(name = "strMeasure7")
    val strMeasure7: String?,
    @Json(name = "strMeasure8")
    val strMeasure8: String?,
    @Json(name = "strMeasure9")
    val strMeasure9: String?,
    @Json(name = "strSource")
    val strSource: Any,
    @Json(name = "strTags")
    val strTags: String,
    @Json(name = "strYoutube")
    val strYoutube: String
) : io.github.andraantariksa.meal.core.domain.entity.Meal(
    area = strArea,
    id = idMeal.toInt(),
    category = strCategory,
    name = strMeal,
    ingredients = mutableListOf<Pair<String, String>>().apply {
        if (strIngredient1 != null && strMeasure1 != null) {
            add(strIngredient1 to strMeasure1)
        }
        if (strIngredient2 != null && strMeasure2 != null) {
            add(strIngredient2 to strMeasure2)
        }
        if (strIngredient3 != null && strMeasure3 != null) {
            add(strIngredient3 to strMeasure3)
        }
        if (strIngredient4 != null && strMeasure4 != null) {
            add(strIngredient4 to strMeasure4)
        }
        if (strIngredient4 != null && strMeasure4 != null) {
            add(strIngredient4 to strMeasure4)
        }
        if (strIngredient5 != null && strMeasure5 != null) {
            add(strIngredient5 to strMeasure5)
        }
        if (strIngredient6 != null && strMeasure6 != null) {
            add(strIngredient6 to strMeasure6)
        }
        if (strIngredient7 != null && strMeasure7 != null) {
            add(strIngredient7 to strMeasure7)
        }
        if (strIngredient8 != null && strMeasure8 != null) {
            add(strIngredient8 to strMeasure8)
        }
        if (strIngredient9 != null && strMeasure9 != null) {
            add(strIngredient9 to strMeasure9)
        }
        if (strIngredient10 != null && strMeasure10 != null) {
            add(strIngredient10 to strMeasure10)
        }
        if (strIngredient11 != null && strMeasure11 != null) {
            add(strIngredient11 to strMeasure11)
        }
        if (strIngredient12 != null && strMeasure12 != null) {
            add(strIngredient12 to strMeasure12)
        }
        if (strIngredient13 != null && strMeasure13 != null) {
            add(strIngredient13 to strMeasure13)
        }
        if (strIngredient14 != null && strMeasure14 != null) {
            add(strIngredient14 to strMeasure14)
        }
        if (strIngredient15 != null && strMeasure15 != null) {
            add(strIngredient15 to strMeasure15)
        }
        if (strIngredient16 != null && strMeasure16 != null) {
            add(strIngredient16 to strMeasure16)
        }
        if (strIngredient17 != null && strMeasure17 != null) {
            add(strIngredient17 to strMeasure17)
        }
        if (strIngredient18 != null && strMeasure18 != null) {
            add(strIngredient18 to strMeasure18)
        }
        if (strIngredient19 != null && strMeasure19 != null) {
            add(strIngredient19 to strMeasure19)
        }
        if (strIngredient20 != null && strMeasure20 != null) {
            add(strIngredient20 to strMeasure20)
        }
    },
    instructions = strInstructions,
    thumbnail = strMealThumb
)