package com.playground.daggerplayground.injection.module;

import android.app.Activity;

import com.playground.daggerplayground.injection.component.MainActivitySubcomponent;
import com.playground.daggerplayground.pages.mainactivity.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Dagger Module for MainActivity.
 * Created by petnagy on 2017. 06. 16..
 */
@Module(subcomponents = MainActivitySubcomponent.class)
public abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);

}

