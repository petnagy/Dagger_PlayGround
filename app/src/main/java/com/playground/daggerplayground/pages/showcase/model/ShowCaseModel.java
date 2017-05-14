package com.playground.daggerplayground.pages.showcase.model;

import android.content.Context;
import android.util.Log;

import com.playground.daggerplayground.data.coffee.LongCoffee;
import com.playground.daggerplayground.data.coffee.ShortCoffee;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;

/**
 * Model of ShowCaseActivity.
 * Created by petnagy on 2017. 05. 08..
 */

public class ShowCaseModel {

    private static final String TAG = ShowCaseModel.class.getSimpleName();

    @Inject
    Context context;

    @Inject
    Lazy<ShortCoffee> lazyShortCoffee;

    @Inject
    Provider<ShortCoffee> providerShortCoffee;

    LongCoffee longCoffee;

    ShortCoffee shortCoffee;

    ShortCoffee providedShortCoffee;

    @Inject
    public ShowCaseModel() {
        Log.d(TAG, "Constructor is running");
    }

    public String getContextValue() {
        return context.toString();
    }

    public String getMyCoffee() {
        return longCoffee.getDrinkName();
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

    public String getLazyShortCoffee() {
        return shortCoffee == null ? "null" : shortCoffee.toString();
    }

    public String getLazyObject() {
        return lazyShortCoffee.toString();
    }

    public void callLazyShortCoffeeGet() {
        shortCoffee = lazyShortCoffee.get();
    }

    public void callProviderShortCoffee() {
        providedShortCoffee = providerShortCoffee.get();
    }

    public String getProvidedObj() {
        return providedShortCoffee == null ? "null" : providedShortCoffee.toString();
    }
}
