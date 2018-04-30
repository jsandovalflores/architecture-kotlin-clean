/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.di

import android.app.Application
import android.content.Context

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by jorgesandovalflores on 23/04/18.
 */

@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return mApplication
    }

}

