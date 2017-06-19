package com.playground.daggerplayground.injection.module;

import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.pages.coffees.CoffeeActivity;
import com.playground.daggerplayground.pages.mainactivity.MainActivity;
import com.playground.daggerplayground.pages.showcase.ShowCaseActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Contains all contributed activity modules for dagger.
 * Created by petnagy on 2017. 06. 18..
 */
@Module
public abstract class ContributesAndroidInjectorModule {

    @PerActivity
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    public abstract MainActivity contributeMainActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = {ShowCaseActivityModule.class, CoffeeModule.class,
            IngredientModule.class, ExtraModule.class})
    public abstract ShowCaseActivity contributeShowCaseActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = {CoffeeActivityModule.class, CoffeeModule.class,
            IngredientModule.class, ExtraModule.class})
    public abstract CoffeeActivity contributeCoffeeActivityInjector();
}
