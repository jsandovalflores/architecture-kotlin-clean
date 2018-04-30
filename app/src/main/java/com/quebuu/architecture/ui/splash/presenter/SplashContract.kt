/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.ui.splash.presenter

import com.quebuu.architecture.ui.BaseContractor
import com.quebuu.architecture.ui.viewmodel.UserViewModel

interface SplashContract {
    interface SplashView : BaseContractor.BaseView {
        fun showUser(userViewModel: UserViewModel)
    }

    interface ISplashPrensenter<V : SplashView> : BaseContractor.IBasePresenter<V> {
        fun fetchUser()
    }
}