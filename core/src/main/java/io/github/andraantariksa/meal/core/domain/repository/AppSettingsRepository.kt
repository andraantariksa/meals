package io.github.andraantariksa.meal.core.domain.repository

import io.github.andraantariksa.meal.core.data.data_source_store.local.data_store.AppSettings
import io.github.andraantariksa.meal.core.util.Theme
import kotlinx.coroutines.flow.Flow

interface AppSettingsRepository {
    val preference: Flow<AppSettings>
    suspend fun setTheme(theme: Theme)
}