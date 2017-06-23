package com.playground.daggerplayground.injection.component;

import android.app.Application;
import android.content.Context;

import com.playground.daggerplayground.DaggerPlayGroundApplication;
import com.playground.daggerplayground.injection.ApplicationContext;
import com.playground.daggerplayground.injection.module.ApplicationModule;
import com.playground.daggerplayground.injection.module.ContributesAndroidInjectorModule;
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
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class, ContributesAndroidInjectorModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerPlayGroundApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<DaggerPlayGroundApplication> {
    }

    @ApplicationContext
    Context getContext();

    PreferenceService provideSharedPreference();
}
