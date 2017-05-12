package com.playground.daggerplayground.injection.component;

import com.playground.daggerplayground.pages.coffees.CoffeeActivity;
import com.playground.daggerplayground.pages.mainactivity.MainActivity;
import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.injection.module.ActivityModule;
import com.playground.daggerplayground.injection.module.CoffeeModule;
import com.playground.daggerplayground.injection.module.ExtraModule;
import com.playground.daggerplayground.injection.module.IngredientModule;
import com.playground.daggerplayground.pages.showcase.ShowCaseActivity;

import dagger.Component;

/**
 * Activity level Component.
 * Created by petnagy on 2017. 04. 30..
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, IngredientModule.class,
        CoffeeModule.class, ExtraModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(CoffeeActivity activity);

    void inject(ShowCaseActivity activity);
}
