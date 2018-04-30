/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture

import android.support.multidex.MultiDexApplication
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.quebuu.architecture.di.ApplicationComponent
import com.quebuu.architecture.di.ApplicationModule
import com.quebuu.architecture.di.DaggerApplicationComponent
import com.quebuu.architecture.util.CrashlyticsTree
import io.fabric.sdk.android.Fabric
import timber.log.Timber

class QuebuuApplication : MultiDexApplication(){

    var applicationComponent: ApplicationComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        settingAndroidLogging()
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    private fun settingAndroidLogging() {
        val core = CrashlyticsCore.Builder()
                .disabled(BuildConfig.DEBUG)
                .build()
        Fabric.with(this, Crashlytics.Builder().core(core).build())
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.plant(CrashlyticsTree())
    }

}