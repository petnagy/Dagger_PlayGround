package com.playground.daggerplayground.injection.component;

import android.app.Application;
import android.content.Context;

import com.playground.daggerplayground.DaggerPlayGroundApplication;
import com.playground.daggerplayground.injection.ApplicationContext;
import com.playground.daggerplayground.injection.module.ApplicationModule;
import com.playground.daggerplayground.services.preference.PreferenceService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by petnagy on 2017. 04. 30..
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();

    Application getApplication();

    PreferenceService provideSharedPreference();

    void inject(DaggerPlayGroundApplication daggerPlayGroundApplication);
}
