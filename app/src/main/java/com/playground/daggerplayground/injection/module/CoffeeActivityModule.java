package com.playground.daggerplayground.injection.module;

import com.playground.daggerplayground.data.coffee.IceLongCoffee;
import com.playground.daggerplayground.data.common.Drink;
import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.pages.coffees.model.CoffeeActivityModel;
import com.playground.daggerplayground.pages.coffees.presenter.CoffeeActivityPresenter;
import com.playground.daggerplayground.pages.coffees.presenter.CoffeeActivityPresenterImpl;
import com.playground.daggerplayground.pages.coffees.view.CoffeeActivityView;
import com.playground.daggerplayground.pages.coffees.view.CoffeeActivityViewImpl;
import com.playground.daggerplayground.services.preference.PreferenceService;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module for MainActivity.
 * Created by petnagy on 2017. 06. 16..
 */
@Module
public class CoffeeActivityModule {

    @Provides
    @PerActivity
    CoffeeActivityView provideCoffeeActivityView() {
        return new CoffeeActivityViewImpl();
    }

    @Provides
    @PerActivity
    CoffeeActivityPresenter provideCoffeeActivityPresenter() {
        return new CoffeeActivityPresenterImpl();
    }

    @Provides
    @PerActivity
    CoffeeActivityModel provideCoffeeActivityModel(PreferenceService preferenceService,
                                                   @Named("COFFEE_LIST") List<Drink> coffeeList,
                                                   @Named("WITH_ICE") IceLongCoffee favoriteDrink) {
        CoffeeActivityModel model = new CoffeeActivityModel();
        model.setLoggedIn(preferenceService.isUserLoggedIn());
        model.setCoffeeList(coffeeList);
        return model;
    }

}

