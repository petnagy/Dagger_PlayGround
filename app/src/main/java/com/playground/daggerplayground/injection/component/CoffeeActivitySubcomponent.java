package com.playground.daggerplayground.injection.component;

import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.injection.module.ActivityModule;
import com.playground.daggerplayground.injection.module.CoffeeModule;
import com.playground.daggerplayground.injection.module.ExtraModule;
import com.playground.daggerplayground.injection.module.IngredientModule;
import com.playground.daggerplayground.pages.coffees.CoffeeActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Subcomponent for CoffeeActivity.
 * Created by petnagy on 2017. 06. 16..
 */
@PerActivity
@Subcomponent(modules = {ActivityModule.class, IngredientModule.class, ExtraModule.class, CoffeeModule.class})
public interface CoffeeActivitySubcomponent extends AndroidInjector<CoffeeActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CoffeeActivity> {
        abstract CoffeeActivitySubcomponent.Builder activityModule(ActivityModule module);
        abstract CoffeeActivitySubcomponent.Builder ingredientModule(IngredientModule module);
        abstract CoffeeActivitySubcomponent.Builder extraModule(ExtraModule module);
        abstract CoffeeActivitySubcomponent.Builder coffeeModule(CoffeeModule module);
        @Override
        public void seedInstance(CoffeeActivity activity) {
            activityModule(new ActivityModule(activity));
            ingredientModule(new IngredientModule());
            extraModule(new ExtraModule());
            coffeeModule(new CoffeeModule());
        }
    }

}
