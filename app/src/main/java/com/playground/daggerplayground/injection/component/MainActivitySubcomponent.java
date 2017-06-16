package com.playground.daggerplayground.injection.component;

import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.injection.module.ActivityModule;
import com.playground.daggerplayground.pages.mainactivity.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Subcomponent for MainActivity.
 * Created by petnagy on 2017. 06. 16..
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
        abstract Builder activityModule(ActivityModule module);

        @Override
        public void seedInstance(MainActivity activity) {
            activityModule(new ActivityModule(activity));
        }
    }

}
