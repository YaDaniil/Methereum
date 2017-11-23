package com.yadaniil.methereum

import android.app.Application
import timber.log.Timber

/**
 * Created by danielyakovlev on 11/21/17.
 */

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
//            Timber.plant(CrashReportTree())
        }
    }
}