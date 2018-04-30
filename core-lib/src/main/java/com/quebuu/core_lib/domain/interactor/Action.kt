/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.core_lib.domain.interactor

interface Action {

    interface Callback<Model> {
        fun onSuccess(response: Model)
        fun onError(ex: Throwable)
    }

    fun run()
}
