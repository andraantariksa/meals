package io.github.andraantariksa.meal.core.data.data_source_store.local.data_store

import io.github.andraantariksa.meal.core.util.Theme

class AppSettings {
    val theme: Theme = Theme.Default

    companion object {
        const val NAME = "APP_SETTINGS"
    }
}