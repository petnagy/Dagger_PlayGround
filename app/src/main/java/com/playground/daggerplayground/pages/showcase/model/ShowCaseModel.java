package com.playground.daggerplayground.pages.showcase.model;

import android.content.Context;
import android.util.Log;

import com.playground.daggerplayground.data.coffee.LongCoffee;

import javax.inject.Inject;

/**
 * Created by petnagy on 2017. 05. 08..
 */

public class ShowCaseModel {

    private static final String TAG = ShowCaseModel.class.getSimpleName();

    @Inject
    Context context;

    LongCoffee longCoffee;

    @Inject
    public ShowCaseModel() {
        Log.d(TAG, "Constructor is running");
    }

    public String getContextValue() {
        return context.toString();
    }

    public String getMyCoffee() {
        return longCoffee.getDrinkiName();
    }

    @Inject
    public void addWatcher(Watcher watcher) {
        Log.d(TAG, "Method injection is running");
        watcher.watch(this);
    }

    @Inject
    public void addLongCoffee(LongCoffee longCoffee) {
        Log.d(TAG, "Method injection is running with coffee");
        this.longCoffee = longCoffee;
    }
}
