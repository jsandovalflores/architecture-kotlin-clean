/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.quebuu.architecture.QuebuuApplication
import com.quebuu.architecture.di.ApplicationComponent
import com.quebuu.architecture.util.AppUtils
import org.jetbrains.anko.ctx

abstract class BaseActivity : AppCompatActivity(), BaseContractor.BaseView{

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        methodAddView()
        initComponent((application as QuebuuApplication).applicationComponent!!)
        progressDialog = ProgressDialog(ctx)
    }

    protected abstract fun methodAddView()
    protected abstract fun initComponent(applicationComponent: ApplicationComponent)

    override fun isConnected(): Boolean {
        return AppUtils.isConnected(this)
    }

    override fun isAirplaneModeOff(): Boolean {
        return AppUtils.isAirplaneModeOff(this)
    }

    override fun showProgress() {
        progressDialog!!.show()
    }

    override fun hideProgress() {
        progressDialog!!.dismiss()
    }

    override fun showErrorMessage(errorMessage: Int) {
        Toast.makeText(this, getString(errorMessage), Toast.LENGTH_LONG).show()
    }

    override fun showErrorMessage(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }
}