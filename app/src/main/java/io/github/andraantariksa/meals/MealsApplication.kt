package io.github.andraantariksa.meals

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp
import io.github.andraantariksa.meal.core.domain.repository.AppSettingsRepository
import io.github.andraantariksa.meal.core.util.Theme
import io.github.andraantariksa.meals.util.log.ReleaseTree
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class MealsApplication : Application() {
    private var applicationScope: CoroutineScope? = null

    @Inject
    lateinit var appSettingsRepository: AppSettingsRepository

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }

        runBlocking {
            applyTheme(appSettingsRepository.preference.first().theme)
        }

        applicationScope = MainScope().apply {
            launch {
                appSettingsRepository.preference.collectLatest { appSettings ->
                    applyTheme(appSettings.theme)
                }
            }
        }
    }

    private fun applyTheme(theme: Theme) {
        AppCompatDelegate.setDefaultNightMode(
            when (theme) {
                Theme.Default -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                Theme.Light -> AppCompatDelegate.MODE_NIGHT_NO
                Theme.Dark -> AppCompatDelegate.MODE_NIGHT_YES
            }
        )
    }

    override fun onTerminate() {
        applicationScope = null
        super.onTerminate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        applicationScope?.cancel()
        applicationScope = MainScope()
    }
}