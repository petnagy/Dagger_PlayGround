package com.playground.daggerplayground.injection.module;

import android.app.Activity;

import com.playground.daggerplayground.data.coffee.IceLongCoffee;
import com.playground.daggerplayground.data.common.Drink;
import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.injection.component.CoffeeActivitySubcomponent;
import com.playground.daggerplayground.pages.coffees.CoffeeActivity;
import com.playground.daggerplayground.pages.coffees.model.CoffeeActivityModel;
import com.playground.daggerplayground.pages.coffees.presenter.CoffeeActivityPresenter;
import com.playground.daggerplayground.pages.coffees.presenter.CoffeeActivityPresenterImpl;
import com.playground.daggerplayground.pages.coffees.view.CoffeeActivityView;
import com.playground.daggerplayground.pages.coffees.view.CoffeeActivityViewImpl;
import com.playground.daggerplayground.pages.mainactivity.MainActivity;
import com.playground.daggerplayground.services.preference.PreferenceService;

import java.util.List;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Dagger Module for MainActivity.
 * Created by petnagy on 2017. 06. 16..
 */
@Module(subcomponents = CoffeeActivitySubcomponent.class)
public abstract class CoffeeActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(CoffeeActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindCoffeeActivityInjectorFactory(CoffeeActivitySubcomponent.Builder builder);

}

