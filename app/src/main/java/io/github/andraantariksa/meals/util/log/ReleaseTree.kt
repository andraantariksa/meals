package io.github.andraantariksa.meals.util.log

import android.util.Log
import timber.log.Timber

class ReleaseTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority < Log.INFO) {
            return
        }

//        Firebase.crashlytics.log(message)
    }
}