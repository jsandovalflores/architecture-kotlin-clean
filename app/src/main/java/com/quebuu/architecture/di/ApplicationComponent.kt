/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.di

import android.content.Context
import com.quebuu.core_lib.domain.interactor.executor.Executor
import com.quebuu.core_lib.domain.interactor.executor.ExecutorModule
import com.quebuu.core_lib.domain.interactor.executor.MainThread

import javax.inject.Singleton

import dagger.Component

/**
 * Created by jorgesandovalflores on 23/04/18.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ExecutorModule::class))
interface ApplicationComponent {
    val context: Context
    val executor: Executor
    val mainThread: MainThread
}