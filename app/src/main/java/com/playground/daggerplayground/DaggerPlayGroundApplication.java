package com.playground.daggerplayground;

import android.app.Application;
import android.content.Context;

import com.playground.daggerplayground.injection.component.ApplicationComponent;
import com.playground.daggerplayground.injection.component.DaggerApplicationComponent;
import com.playground.daggerplayground.injection.module.ApplicationModule;

/**
 * Application class for DaggerPlayGround.
 * Created by petnagy on 2017. 05. 01..
 */

public class DaggerPlayGroundApplication extends Application {

    protected ApplicationComponent applicationComponent;

    public static DaggerPlayGroundApplication get(Context context) {
        return (DaggerPlayGroundApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
