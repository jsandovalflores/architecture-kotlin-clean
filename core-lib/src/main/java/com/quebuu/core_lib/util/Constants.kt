/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.core_lib.util

import java.util.concurrent.TimeUnit

object Constants {
    val EMPTY = ""
    val HTTP_TIMEOUT = 20000

    //ThreadPool
    val CORE_POOL_SIZE = 10
    val MAX_POOL_SIZE = 15
    val KEEP_ALIVE_TIME = 120
    val AUTHORIZATION = "Bearer "
    val TIME_UNIT = TimeUnit.SECONDS

    val PLATFORM = "android"
}
