package com.playground.daggerplayground.injection.module;

import android.app.Activity;

import com.playground.daggerplayground.injection.component.ShowCaseActivitySubcomponent;
import com.playground.daggerplayground.pages.showcase.ShowCaseActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Dagger Module for MainActivity.
 * Created by petnagy on 2017. 06. 16..
 */
@Module(subcomponents = ShowCaseActivitySubcomponent.class)
public abstract class ShowCaseActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(ShowCaseActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindShowCaseActivityInjectorFactory(ShowCaseActivitySubcomponent.Builder builder);

}

