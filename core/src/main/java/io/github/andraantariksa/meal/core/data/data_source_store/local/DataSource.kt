package io.github.andraantariksa.meal.core.data.data_source_store.local.data_source

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import io.github.andraantariksa.meal.core.data.data_source_store.local.AppSettings

val Context.appSettingsDataStore by preferencesDataStore(AppSettings.NAME)
