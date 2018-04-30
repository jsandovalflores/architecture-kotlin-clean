/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.ui

import android.support.annotation.StringRes
import com.quebuu.architecture.R
import com.quebuu.core_lib.exception.LocalDataBaseException
import com.quebuu.core_lib.exception.NetworkException
import com.quebuu.core_lib.exception.UnAuthorizedApiException

abstract class BaseContractor {

    interface BaseView {
        fun isConnected(): Boolean
        fun isAirplaneModeOff(): Boolean
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(@StringRes errorMessage: Int)
        fun showErrorMessage(errorMessage: String)
    }

    interface IBasePresenter<V : BaseView> {
        fun attachView(view: V)
        fun detachView()
    }

    abstract class BasePresenter<V : BaseView> : IBasePresenter<V> {
        protected var mView: V? = null

        protected val isViewAttached: Boolean
            get() = mView != null

        override fun attachView(view: V) {
            mView = view
        }

        override fun detachView() {
            mView = null
        }

        protected fun errorHandler(ex: Throwable) {
            ex.printStackTrace()
            if (ex is LocalDataBaseException) {
                mView!!.showErrorMessage(ex.idResMessage)
            } else if (ex is UnAuthorizedApiException) {
                mView!!.showErrorMessage(R.string.exception_unauthorized_api)
            } else if (ex is NetworkException) {
                if (ex.httpCode == 404) {
                    mView!!.showErrorMessage(R.string.exception_404_not_found)
                }
                if (ex.httpCode == 502) {
                    mView!!.showErrorMessage(R.string.exception_connection_error)
                }
            } else {
                mView!!.showErrorMessage(R.string.exception_connection_error)
            }
        }
    }
}
