/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.ui.signin

import android.graphics.Color
import android.text.InputType
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import com.quebuu.architecture.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class SigninLayout : AnkoComponent<SigninActivity>{

    lateinit var edEmail    : EditText
    lateinit var edPassword : EditText

    override fun createView(ui: AnkoContext<SigninActivity>) = with(ui) {
        verticalLayout {
            gravity = Gravity.CENTER
            padding = dip(20)

            textView {
                gravity = Gravity.CENTER
                text = "Signin"
                textColor = Color.BLACK
                textSize = 24f
            }.lparams(width = matchParent) {
                margin = dip(30)
            }

            edEmail = editText {
                id = R.id.ed_email
                hint = "Email"
                imeOptions = EditorInfo.IME_ACTION_NEXT
                inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            }

            edPassword = editText {
                id = R.id.ed_password
                hint = "Password"
                imeOptions = EditorInfo.IME_ACTION_SEND
                inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }

            button("Login") {
                backgroundColor = resources.getColor(R.color.colorAccent)
                textColor = resources.getColor(R.color.white)
                onClick {
                    toast( "Hola ${edEmail.text}, Ingreso correcto")
                }
            }.lparams(width = matchParent,  height = wrapContent){
                topMargin = dip(30)
            }
        }
    }

}