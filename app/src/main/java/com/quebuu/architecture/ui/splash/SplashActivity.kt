/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Handler
import com.quebuu.architecture.di.ApplicationComponent
import com.quebuu.architecture.di.DaggerComponentContract_SplashComponent
import com.quebuu.architecture.ui.BaseActivity
import com.quebuu.architecture.ui.signin.SigninActivity
import com.quebuu.architecture.ui.viewmodel.UserViewModel
import com.quebuu.architecture.ui.splash.presenter.SplashContract
import com.quebuu.architecture.ui.splash.presenter.SplashModule
import org.jetbrains.anko.ctx
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.SplashView {

    @Inject lateinit var mPresenter: SplashContract.ISplashPrensenter<SplashContract.SplashView>
    lateinit var ui : SplashLayout

    override fun methodAddView() {
        ui = SplashLayout()
        ui.setContentView(this)
    }

    override fun onStart() {
        super.onStart()
        mPresenter.fetchUser()
    }

    override fun initComponent(applicationComponent: ApplicationComponent) {
        DaggerComponentContract_SplashComponent.builder()
                .applicationComponent(applicationComponent)
                .splashModule(SplashModule(this))
                .build()
                .inject(this)
    }

    fun nexScreen(){
        Handler().postDelayed({
            finish()
            startActivity(SigninActivity.newIntent(ctx))
        }, 2000)
    }

    companion object {
        fun newIntent(context: Context) : Intent{
            val intent = Intent(context, SplashActivity::class.java)
            return intent
        }
    }

    override fun showUser(userViewModel: UserViewModel) {
        nexScreen()
    }

}