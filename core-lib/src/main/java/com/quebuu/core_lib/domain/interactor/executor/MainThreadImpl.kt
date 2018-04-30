/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.core_lib.domain.interactor.executor

import android.os.Handler
import android.os.Looper

import javax.inject.Inject

class MainThreadImpl @Inject
constructor() : MainThread {

    private val mHandler: Handler

    init {
        this.mHandler = Handler(Looper.getMainLooper())
    }

    override fun post(runnable: Runnable) {
        mHandler.post(runnable)
    }
}
