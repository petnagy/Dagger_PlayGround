package com.playground.daggerplayground.pages.showcase.model;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by petnagy on 2017. 05. 08..
 */

public class ShowCaseModel {

    private static final String TAG = ShowCaseModel.class.getSimpleName();

    @Inject
    Context context;

    @Inject
    public ShowCaseModel() {
    }

    public String getContextValue() {
        return context.toString();
    }

    @Inject
    public void addWatcher(Watcher watcher) {
        Log.d(TAG, "Method injection is running");
        watcher.watch(this);
    }
}
