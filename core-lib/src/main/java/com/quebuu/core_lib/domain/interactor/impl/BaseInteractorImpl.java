/*
 * *
 *  * Created by Jorge Sandoval Flores(jorge@quebuu.com) on 30/04/18 04:38 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *
 */

package com.quebuu.core_lib.domain.interactor.impl;

import com.quebuu.core_lib.domain.interactor.Action;
import com.quebuu.core_lib.domain.interactor.executor.MainThread;

import javax.inject.Inject;

public abstract class BaseInteractorImpl {

    @Inject
    MainThread mainThread;

    void notifySuccess(final Object response, final Action.Callback callback) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(response);
            }
        });
    }

    void notifyError(final Throwable throwable, final Action.Callback callback) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(throwable);
            }
        });
    }

}
