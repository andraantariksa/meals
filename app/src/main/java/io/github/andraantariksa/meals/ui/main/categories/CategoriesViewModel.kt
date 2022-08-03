package io.github.andraantariksa.meals.ui.main.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.andraantariksa.meal.core.domain.entity.Category
import io.github.andraantariksa.meal.core.domain.repository.MealsRepository
import io.github.andraantariksa.meal.core.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val mealsRepository: MealsRepository) :
    ViewModel() {
    private val _categories = MutableStateFlow<Resource<List<Category>>>(Resource.Loading())
    val category = _categories.asStateFlow()

    init {
        viewModelScope.launch {
            fetchCategories()
        }
    }

    private suspend fun fetchCategories() {
        _categories.value = Resource.Loading()
        mealsRepository.getCategories()
            .onSuccess { _categories.value = Resource.Success(it) }
            .onFailure { _categories.value = Resource.Error(it) }
    }
}