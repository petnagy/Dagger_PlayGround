package com.playground.daggerplayground.injection.module;

import android.app.Application;
import android.content.Context;

import com.playground.daggerplayground.injection.ApplicationContext;
import com.playground.daggerplayground.services.preference.PreferenceService;
import com.playground.daggerplayground.services.preference.SharedPreferenceService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by petnagy on 2017. 04. 30..
 */
@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Singleton
    @Provides
    PreferenceService provideSharedPreference(@ApplicationContext Context context) {
        return new SharedPreferenceService();
    }
}
