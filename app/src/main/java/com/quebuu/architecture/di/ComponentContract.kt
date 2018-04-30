/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.di

import com.quebuu.architecture.ui.splash.SplashActivity
import com.quebuu.architecture.ui.splash.presenter.SplashModule
import dagger.Component

interface ComponentContract {

    @ActivityScope
    @Component(modules = arrayOf(SplashModule::class), dependencies = arrayOf(ApplicationComponent::class))
    interface SplashComponent {
        fun inject(splashActivity: SplashActivity)
    }

}