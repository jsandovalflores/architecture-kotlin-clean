/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.core_lib.domain.interactor.executor

import com.quebuu.core_lib.util.Constants
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class ExecutorModule {

    @Provides
    @Singleton
    internal fun provideBlockingQueue(): BlockingQueue<Runnable> {
        return LinkedBlockingQueue()
    }

    @Provides
    @Singleton
    internal fun provideThreadPoolExecutor(workQueue: BlockingQueue<Runnable>): ThreadPoolExecutor {
        val corePoolSize = Constants.CORE_POOL_SIZE
        val maxPoolSize = Constants.MAX_POOL_SIZE
        val keepAliveTime = Constants.KEEP_ALIVE_TIME
        val timeUnit = Constants.TIME_UNIT
        return ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime.toLong(), timeUnit, workQueue)
    }

    @Provides
    @Singleton
    internal fun provideExecutor(threadPoolExecutor: ThreadPoolExecutor): Executor {
        return ThreadExecutor(threadPoolExecutor)
    }

    @Provides
    @Singleton
    internal fun provideMainThread(): MainThread {
        return MainThreadImpl()
    }
}
