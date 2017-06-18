package com.playground.daggerplayground;

import com.playground.daggerplayground.injection.component.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Application class for DaggerPlayGround.
 * Created by petnagy on 2017. 05. 01..
 */

public class DaggerPlayGroundApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().create(this);
    }
}
