/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.core_lib.domain.interactor.executor

import com.quebuu.core_lib.domain.interactor.Action
import java.util.concurrent.ThreadPoolExecutor

import javax.inject.Inject

class ThreadExecutor @Inject
constructor(private val mThreadPoolExecutor: ThreadPoolExecutor) : Executor {

    override fun execute(action: Action) {
        if (action == null) {
            throw IllegalArgumentException("Interactor to execute can't be null")
        }
        mThreadPoolExecutor.submit { action.run() }
    }
}
