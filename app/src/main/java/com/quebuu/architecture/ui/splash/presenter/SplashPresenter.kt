/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.ui.splash.presenter

import com.quebuu.core_lib.R
import com.quebuu.core_lib.domain.interactor.Action
import com.quebuu.core_lib.domain.interactor.UserInteractor
import com.quebuu.core_lib.domain.repository.model.UserModel
import com.quebuu.core_lib.exception.ApiException
import com.quebuu.architecture.ui.BaseContractor
import com.quebuu.architecture.ui.viewmodel.mapper.UserMapper
import javax.inject.Inject

class SplashPresenter<V : SplashContract.SplashView> @Inject constructor() : BaseContractor.BasePresenter<V>(), SplashContract.ISplashPrensenter<V> {

    @Inject lateinit var userInteractor: UserInteractor

    override fun fetchUser() {
        mView!!.showProgress()
        if (mView!!.isConnected()) {
            if (mView!!.isAirplaneModeOff()) {
                doGetUser()
            } else {
                if (isViewAttached) {
                    mView!!.hideProgress()
                    mView!!.showErrorMessage(R.string.exception_no_internet_error)
                }
            }
        } else {
            mView!!.hideProgress()
            mView!!.showErrorMessage(R.string.exception_connection_error)
        }
    }

    private fun doGetUser() {
        userInteractor.fetchUser(object : Action.Callback<UserModel>{
            override fun onSuccess(response: UserModel) {
                if (isViewAttached) {
                    mView!!.hideProgress()
                    mView!!.showUser(UserMapper.mapModelToViewModel(response))
                }
            }

            override fun onError(ex: Throwable) {
                if (isViewAttached)
                    mView!!.hideProgress()
                if (ex is ApiException) {
                    if (isViewAttached)
                        mView!!.showErrorMessage(ex.errorMessage)
                } else {
                    errorHandler(ex)
                }
            }
        })
    }
    
}