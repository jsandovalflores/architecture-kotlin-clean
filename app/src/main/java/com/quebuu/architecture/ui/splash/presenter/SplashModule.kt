/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.ui.splash.presenter

import com.quebuu.core_lib.domain.interactor.UserInteractor
import com.quebuu.core_lib.domain.interactor.impl.UserInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class SplashModule(private val mView: SplashContract.SplashView) {

    @Provides
    internal fun provideLoginView(): SplashContract.SplashView {
        return mView
    }

    @Provides
    internal fun provideUserInteractor(userInteractor : UserInteractorImpl): UserInteractor {
        return userInteractor
    }

    @Provides
    internal fun provideSplashPresenter(presenter: SplashPresenter<SplashContract.SplashView>): SplashContract.ISplashPrensenter<SplashContract.SplashView> {
        presenter.attachView(mView)
        return presenter
    }

}