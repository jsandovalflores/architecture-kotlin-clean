/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.core_lib.domain.interactor.impl

import com.quebuu.core_lib.R
import com.quebuu.core_lib.domain.interactor.Action
import com.quebuu.core_lib.domain.interactor.UserInteractor
import com.quebuu.core_lib.domain.interactor.executor.Executor
import com.quebuu.core_lib.domain.repository.model.UserModel
import com.quebuu.core_lib.exception.CallbackNullPointerException
import javax.inject.Inject

class UserInteractorImpl @Inject constructor() : BaseInteractorImpl(), UserInteractor{

    @Inject lateinit var executor: Executor

    override fun fetchUser(callback: Action.Callback<UserModel>) {
        if (null == callback) { throw CallbackNullPointerException(R.string.exception_callback_null) }
        this.executor!!.execute(object : Action {
            override fun run() {
                var userModel = UserModel(1, "Jorge", "Sandoval Flores")
                notifySuccess(userModel, callback)
            }
        })
    }

}