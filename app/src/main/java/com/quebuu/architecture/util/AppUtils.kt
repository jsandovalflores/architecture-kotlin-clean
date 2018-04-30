/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.architecture.util

import android.annotation.TargetApi
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.provider.Settings
import android.util.DisplayMetrics

object AppUtils {
    fun isConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val networks = connectivityManager.allNetworks
            var networkInfo: NetworkInfo
            for (mNetwork in networks) {
                networkInfo = connectivityManager.getNetworkInfo(mNetwork)
                if (networkInfo.state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
        } else {
            if (connectivityManager != null) {
                val info = connectivityManager.allNetworkInfo
                if (info != null) {
                    for (anInfo in info) {
                        if (anInfo.state == NetworkInfo.State.CONNECTED) {
                            return true
                        }
                    }
                }
            }
        }
        return false
    }

    public fun capitalize(line: String): String {
        var newLine = line.toLowerCase()
        if(newLine.substring(0,1).equals("¿")){
            return newLine.substring(0, 2).toUpperCase() + newLine.subSequence(2, newLine.length)
        } else {
            return Character.toUpperCase(newLine[0]) + newLine.substring(1)
        }
    }

    /**
     * Gets the state of Airplane Mode.
     * @param context
     * @return true if disabled.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun isAirplaneModeOff(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Settings.System.getInt(context.contentResolver,
                    Settings.System.AIRPLANE_MODE_ON, 0) == 0
        } else {
            Settings.Global.getInt(context.contentResolver,
                    Settings.Global.AIRPLANE_MODE_ON, 0) == 0
        }
    }

    fun dpToPx(context: Context, dp: Int): Int {
        val displayMetrics = context.resources.displayMetrics
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }
}
