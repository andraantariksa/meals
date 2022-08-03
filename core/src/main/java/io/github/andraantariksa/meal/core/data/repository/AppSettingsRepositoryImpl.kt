package io.github.andraantariksa.meal.core.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import io.github.andraantariksa.meal.core.data.data_source_store.local.data_store.AppSettings
import io.github.andraantariksa.meal.core.data.data_source_store.local.data_store.appSettingsDataStore
import io.github.andraantariksa.meal.core.domain.repository.AppSettingsRepository
import io.github.andraantariksa.meal.core.util.Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class AppSettingsRepositoryImpl @Inject constructor(@ApplicationContext private val context: Context): AppSettingsRepository {
    override val preference: Flow<AppSettings> get() = context.appSettingsDataStore
        .data
        .catch { exception ->
            if (exception is IOException) {
                Timber.e("Error reading preferences", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            mapAppPreferences(preferences)
        }

    private fun mapAppPreferences(preferences: Preferences): AppSettings {
        val theme = Theme.valueOf(preferences[AppSettings.KEY_THEME] ?: Theme.Default.name)

        return AppSettings(theme)
    }

    override suspend fun setTheme(theme: Theme) {
        context.appSettingsDataStore.edit { preferences ->
            preferences[AppSettings.KEY_THEME] = theme.name
        }
    }
}