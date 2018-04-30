/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.ui.signin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView

class SigninActivity : AppCompatActivity(){

    lateinit var ui : SigninLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = SigninLayout()
        ui.setContentView(this)
        ui.edEmail.setText("jorge@quebuu.com")
    }

    companion object {
        fun newIntent(context: Context) : Intent {
            val intent = Intent(context, SigninActivity::class.java)
            return intent
        }
    }

}