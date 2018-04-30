/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.core_lib.exception

import android.support.annotation.StringRes
import com.quebuu.core_lib.util.Constants

class CallbackNullPointerException(@param:StringRes val idResMessage: Int) : IllegalArgumentException(Constants.EMPTY)
