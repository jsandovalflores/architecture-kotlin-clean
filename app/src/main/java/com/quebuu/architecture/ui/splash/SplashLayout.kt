/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.ui.splash

import android.view.Gravity
import android.widget.LinearLayout
import com.quebuu.architecture.R
import org.jetbrains.anko.*

class SplashLayout : AnkoComponent<SplashActivity>{

    override fun createView(ui: AnkoContext<SplashActivity>) = with(ui) {
        linearLayout {
            id = R.id.ly_principal
            orientation = LinearLayout.VERTICAL
            backgroundResource = R.drawable.bg_splash
            gravity = Gravity.CENTER
            lparams(width  = matchParent, height = matchParent)
            textView {
                text = resources.getString(R.string.app_name)
                textColor = resources.getColor(R.color.white)
                gravity = Gravity.CENTER
                textSize = 20f
            }.lparams(width  = wrapContent, height = wrapContent)
        }
    }

}