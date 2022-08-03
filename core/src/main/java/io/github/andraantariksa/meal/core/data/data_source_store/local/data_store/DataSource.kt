package io.github.andraantariksa.meal.core.data.data_source_store.local.data_store

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.appSettingsDataStore by preferencesDataStore(AppSettings.NAME)
