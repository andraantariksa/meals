package io.github.andraantariksa.meals

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.github.andraantariksa.meal.core.domain.repository.AppPreferenceRepository
import io.github.andraantariksa.meals.util.log.ReleaseTree
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class MealsApplication: Application() {
    private var applicationScope: CoroutineScope? = null

    @Inject
    lateinit var appPreferenceRepository: AppPreferenceRepository

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }

        applicationScope = MainScope().apply {
            launch {
//                appPreferenceStore.preference().collectLatest { appSettings ->
//                    val themeAppCompat = when (appSettings.theme) {
//                        Theme.Default -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
//                        Theme.Light -> AppCompatDelegate.MODE_NIGHT_NO
//                        Theme.Dark -> AppCompatDelegate.MODE_NIGHT_YES
//                    }
//                    AppCompatDelegate.setDefaultNightMode(themeAppCompat)
//                }
            }
        }
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