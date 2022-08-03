package io.github.andraantariksa.meals.ui.main.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.andraantariksa.meal.core.data.repository.AppSettingsRepositoryImpl
import io.github.andraantariksa.meal.core.util.Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val appSettings: AppSettingsRepositoryImpl) :
    ViewModel() {
    private val _theme = MutableStateFlow(Theme.Default)
    val theme = _theme.asStateFlow()

    init {
        viewModelScope.launch {
            appSettings.preference.collectLatest { appSettings ->
                _theme.value = appSettings.theme
            }
        }
    }

    fun onIntent(intent: SettingsIntent) {
        when(intent) {
            is SettingsIntent.SetTheme -> viewModelScope.launch {
                appSettings.setTheme(intent.theme)
            }
        }
    }
}