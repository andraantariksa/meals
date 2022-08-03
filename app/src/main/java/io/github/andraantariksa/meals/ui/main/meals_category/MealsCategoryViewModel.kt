package io.github.andraantariksa.meals.ui.main.meals_category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.andraantariksa.meal.core.domain.entity.Meal
import io.github.andraantariksa.meal.core.domain.entity.MealOverview
import io.github.andraantariksa.meal.core.domain.repository.MealsRepository
import io.github.andraantariksa.meal.core.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsCategoryViewModel @Inject constructor(private val mealsRepository: MealsRepository) :
    ViewModel() {
    private val _meals = MutableStateFlow<Resource<List<MealOverview>>>(Resource.Loading())
    val meals = _meals.asStateFlow()

    fun onIntent(intent: MealsCategoryIntent) {
        when (intent) {
            is MealsCategoryIntent.FetchMeals -> viewModelScope.launch {
                fetchMeals(intent.id)
            }
        }
    }

    private suspend fun fetchMeals(id: String) {
        _meals.value = Resource.Loading()
        mealsRepository.getCategoryMeals(id)
            .onSuccess { _meals.value = Resource.Success(it) }
            .onFailure { _meals.value = Resource.Error(it) }
    }
}