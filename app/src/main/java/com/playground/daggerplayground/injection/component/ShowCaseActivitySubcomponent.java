package com.playground.daggerplayground.injection.component;

import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.injection.module.ActivityModule;
import com.playground.daggerplayground.injection.module.CoffeeModule;
import com.playground.daggerplayground.injection.module.ExtraModule;
import com.playground.daggerplayground.injection.module.IngredientModule;
import com.playground.daggerplayground.pages.coffees.CoffeeActivity;
import com.playground.daggerplayground.pages.showcase.ShowCaseActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Subcomponent for showcaseActivity.
 * Created by petnagy on 2017. 06. 16..
 */
@PerActivity
@Subcomponent(modules = {ActivityModule.class, IngredientModule.class, ExtraModule.class, CoffeeModule.class})
public interface ShowCaseActivitySubcomponent extends AndroidInjector<ShowCaseActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ShowCaseActivity> {
        abstract ShowCaseActivitySubcomponent.Builder activityModule(ActivityModule module);
        abstract ShowCaseActivitySubcomponent.Builder ingredientModule(IngredientModule module);
        abstract ShowCaseActivitySubcomponent.Builder extraModule(ExtraModule module);
        abstract ShowCaseActivitySubcomponent.Builder coffeeModule(CoffeeModule module);
        @Override
        public void seedInstance(ShowCaseActivity activity) {
            activityModule(new ActivityModule(activity));
            ingredientModule(new IngredientModule());
            extraModule(new ExtraModule());
            coffeeModule(new CoffeeModule());
        }
    }

}
