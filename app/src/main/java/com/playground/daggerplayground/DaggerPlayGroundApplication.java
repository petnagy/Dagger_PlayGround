package com.playground.daggerplayground;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.playground.daggerplayground.injection.component.DaggerApplicationComponent;
import com.playground.daggerplayground.injection.module.ApplicationModule;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingActivityInjector;

/**
 * Application class for DaggerPlayGround.
 * Created by petnagy on 2017. 05. 01..
 */

public class DaggerPlayGroundApplication extends Application implements HasDispatchingActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    public static DaggerPlayGroundApplication get(Context context) {
        return (DaggerPlayGroundApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build()
                .inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
