package io.github.andraantariksa.meals.ui.main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.andraantariksa.meal.core.domain.entity.Meal
import io.github.andraantariksa.meal.core.domain.repository.MealsRepository
import io.github.andraantariksa.meal.core.util.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val mealsRepository: MealsRepository) :
    ViewModel() {
    private val _searchResult = MutableStateFlow<Resource<List<Meal>>>(Resource.Idle())
    val searchResult = _searchResult.asStateFlow()

    private var searchJob: Job? = null

    fun onIntent(intent: SearchIntent) {
        when (intent) {
            is SearchIntent.Search -> search(intent.query)
        }
    }

    private fun search(query: String?) {
        _searchResult.value = Resource.Loading()
        searchJob?.cancel()
        if (query?.isNotBlank() != true) {
            _searchResult.value = Resource.Idle()
            return
        }
        searchJob = viewModelScope.launch {
            delay(1300)
            mealsRepository.search(query)
                .onSuccess { _searchResult.value = Resource.Success(it) }
                .onFailure { _searchResult.value = Resource.Error(it) }
            searchJob = null
        }
    }
}
