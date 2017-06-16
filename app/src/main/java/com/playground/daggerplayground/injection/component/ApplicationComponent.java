package com.playground.daggerplayground.injection.component;

import android.app.Application;
import android.content.Context;

import com.playground.daggerplayground.DaggerPlayGroundApplication;
import com.playground.daggerplayground.injection.ApplicationContext;
import com.playground.daggerplayground.injection.module.ApplicationModule;
import com.playground.daggerplayground.injection.module.CoffeeActivityModule;
import com.playground.daggerplayground.injection.module.MainActivityModule;
import com.playground.daggerplayground.injection.module.ShowCaseActivityModule;
import com.playground.daggerplayground.services.preference.PreferenceService;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Application level component.
 * Created by petnagy on 2017. 04. 30..
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class, MainActivityModule.class,
        CoffeeActivityModule.class, ShowCaseActivityModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerPlayGroundApplication> {

    @ApplicationContext
    Context getContext();

    Application getApplication();

    PreferenceService provideSharedPreference();

    void inject(DaggerPlayGroundApplication daggerPlayGroundApplication);
}
