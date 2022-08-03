package io.github.andraantariksa.meals.ui.main.settings

import io.github.andraantariksa.meal.core.util.Theme

sealed class SettingsIntent {
    class SetTheme(val theme: Theme): SettingsIntent()
}