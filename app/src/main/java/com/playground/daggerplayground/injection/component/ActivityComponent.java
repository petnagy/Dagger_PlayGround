package com.playground.daggerplayground.injection.component;

import com.playground.daggerplayground.pages.mainactivity.MainActivity;
import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.injection.module.ActivityModule;
import com.playground.daggerplayground.injection.module.CoffeeModule;
import com.playground.daggerplayground.injection.module.ExtraModule;
import com.playground.daggerplayground.injection.module.IngradientModule;

import dagger.Component;

/**
 * Created by petnagy on 2017. 04. 30..
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, IngradientModule.class,
        CoffeeModule.class, ExtraModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);

}
