package io.github.andraantariksa.meal.core.data.data_source_store.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meal(
    @Json(name = "dateModified")
    val dateModified: String?,
    @Json(name = "idMeal")
    val idMeal: String,
    @Json(name = "strArea")
    val strArea: String,
    @Json(name = "strCategory")
    val strCategory: String,
    @Json(name = "strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String?,
    @Json(name = "strDrinkAlternate")
    val strDrinkAlternate: String?,
    @Json(name = "strImageSource")
    val strImageSource: String?,
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
    val strSource: String?,
    @Json(name = "strTags")
    val strTags: String?,
    @Json(name = "strYoutube")
    val strYoutube: String?
) : io.github.andraantariksa.meal.core.domain.entity.Meal(
    area = strArea,
    id = idMeal.toInt(),
    category = strCategory,
    name = strMeal,
    ingredients = mutableListOf<Pair<String, String>>().apply {
        if (strIngredient1?.isNotBlank() == true && strMeasure1?.isNotBlank() == true) {
            add(strIngredient1 to strMeasure1)
        }
        if (strIngredient2?.isNotBlank() == true && strMeasure2?.isNotBlank() == true) {
            add(strIngredient2 to strMeasure2)
        }
        if (strIngredient3?.isNotBlank() == true && strMeasure3?.isNotBlank() == true) {
            add(strIngredient3 to strMeasure3)
        }
        if (strIngredient4?.isNotBlank() == true && strMeasure4?.isNotBlank() == true) {
            add(strIngredient4 to strMeasure4)
        }
        if (strIngredient4?.isNotBlank() == true && strMeasure4?.isNotBlank() == true) {
            add(strIngredient4 to strMeasure4)
        }
        if (strIngredient5?.isNotBlank() == true && strMeasure5?.isNotBlank() == true) {
            add(strIngredient5 to strMeasure5)
        }
        if (strIngredient6?.isNotBlank() == true && strMeasure6?.isNotBlank() == true) {
            add(strIngredient6 to strMeasure6)
        }
        if (strIngredient7?.isNotBlank() == true && strMeasure7?.isNotBlank() == true) {
            add(strIngredient7 to strMeasure7)
        }
        if (strIngredient8?.isNotBlank() == true && strMeasure8?.isNotBlank() == true) {
            add(strIngredient8 to strMeasure8)
        }
        if (strIngredient9?.isNotBlank() == true && strMeasure9?.isNotBlank() == true) {
            add(strIngredient9 to strMeasure9)
        }
        if (strIngredient10?.isNotBlank() == true && strMeasure10?.isNotBlank() == true) {
            add(strIngredient10 to strMeasure10)
        }
        if (strIngredient11?.isNotBlank() == true && strMeasure11?.isNotBlank() == true) {
            add(strIngredient11 to strMeasure11)
        }
        if (strIngredient12?.isNotBlank() == true && strMeasure12?.isNotBlank() == true) {
            add(strIngredient12 to strMeasure12)
        }
        if (strIngredient13?.isNotBlank() == true && strMeasure13?.isNotBlank() == true) {
            add(strIngredient13 to strMeasure13)
        }
        if (strIngredient14?.isNotBlank() == true && strMeasure14?.isNotBlank() == true) {
            add(strIngredient14 to strMeasure14)
        }
        if (strIngredient15?.isNotBlank() == true && strMeasure15?.isNotBlank() == true) {
            add(strIngredient15 to strMeasure15)
        }
        if (strIngredient16?.isNotBlank() == true && strMeasure16?.isNotBlank() == true) {
            add(strIngredient16 to strMeasure16)
        }
        if (strIngredient17?.isNotBlank() == true && strMeasure17?.isNotBlank() == true) {
            add(strIngredient17 to strMeasure17)
        }
        if (strIngredient18?.isNotBlank() == true && strMeasure18?.isNotBlank() == true) {
            add(strIngredient18 to strMeasure18)
        }
        if (strIngredient19?.isNotBlank() == true && strMeasure19?.isNotBlank() == true) {
            add(strIngredient19 to strMeasure19)
        }
        if (strIngredient20?.isNotBlank() == true && strMeasure20?.isNotBlank() == true) {
            add(strIngredient20 to strMeasure20)
        }
    },
    instructions = strInstructions,
    thumbnail = strMealThumb,
    youtubeId = strYoutube?.substringAfter("v=")
)