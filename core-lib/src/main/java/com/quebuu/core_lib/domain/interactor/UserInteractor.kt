/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.core_lib.domain.interactor

import com.quebuu.core_lib.domain.repository.model.UserModel

interface UserInteractor {
    fun fetchUser(callback: Action.Callback<UserModel>)
}