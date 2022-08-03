package io.github.andraantariksa.meals.ui.main.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.andraantariksa.meal.core.domain.entity.Meal
import io.github.andraantariksa.meal.core.domain.repository.MealsRepository
import io.github.andraantariksa.meal.core.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(private val mealsRepository: MealsRepository) :
    ViewModel() {
    private val _meal = MutableStateFlow<Resource<Meal>>(Resource.Loading())
    val meal = _meal.asStateFlow()

    fun onIntent(intent: MealIntent) {
        when (intent) {
            is MealIntent.FetchMeal -> viewModelScope.launch {
                fetchMeal(intent.id)
            }
        }
    }

    private suspend fun fetchMeal(id: Int) {
        _meal.value = Resource.Loading()
        mealsRepository.getMeal(id)
            .onSuccess { _meal.value = Resource.Success(it) }
            .onFailure { _meal.value = Resource.Error(it) }
    }
}