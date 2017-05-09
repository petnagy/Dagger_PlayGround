package com.playground.daggerplayground.pages.showcase.model;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by petnagy on 2017. 05. 09..
 */

public class Watcher {

    private static final String TAG = Watcher.class.getSimpleName();

    @Inject
    public Watcher() {
    }

    public void watch(ShowCaseModel showCaseModel) {
        boolean isShowCaseModel = showCaseModel != null;
        Log.d(TAG, "showCaseModel: " + Boolean.toString(isShowCaseModel));
        if (isShowCaseModel) {
            Log.d(TAG, "Context: " + showCaseModel.getContextValue());
        }
    }
}
