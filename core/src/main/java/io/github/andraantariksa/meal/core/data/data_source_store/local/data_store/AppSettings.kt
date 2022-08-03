package io.github.andraantariksa.meal.core.data.data_source_store.local.data_store

import androidx.datastore.preferences.core.stringPreferencesKey
import io.github.andraantariksa.meal.core.util.Theme

data class AppSettings(
    val theme: Theme
) {

    companion object {
        val KEY_THEME = stringPreferencesKey("theme")

        const val NAME = "APP_SETTINGS"
    }
}