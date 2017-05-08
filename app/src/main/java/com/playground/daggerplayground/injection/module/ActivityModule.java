package com.playground.daggerplayground.injection.module;

import android.app.Activity;
import android.content.Context;

import com.playground.daggerplayground.data.coffee.IceLongCoffee;
import com.playground.daggerplayground.data.common.Drink;
import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.pages.coffees.model.CoffeeActivityModel;
import com.playground.daggerplayground.pages.coffees.presenter.CoffeeActivityPresenter;
import com.playground.daggerplayground.pages.coffees.presenter.CoffeeActivityPresenterImpl;
import com.playground.daggerplayground.pages.coffees.view.CoffeeActivityView;
import com.playground.daggerplayground.pages.coffees.view.CoffeeActivityViewImpl;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;
import com.playground.daggerplayground.pages.mainactivity.presenter.MainActivityPresenter;
import com.playground.daggerplayground.pages.mainactivity.presenter.MainActivityPresenterImpl;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityView;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityViewImpl;
import com.playground.daggerplayground.pages.showcase.presenter.ShowCasePresenter;
import com.playground.daggerplayground.pages.showcase.presenter.ShowCasePresenterImpl;
import com.playground.daggerplayground.pages.showcase.view.ShowCaseView;
import com.playground.daggerplayground.pages.showcase.view.ShowCaseViewImpl;
import com.playground.daggerplayground.services.preference.PreferenceService;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by petnagy on 2017. 04. 30..
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    MainActivityView provideMainActivityView() {
        return new MainActivityViewImpl();
    }

    @Provides
    @PerActivity
    MainActivityModel provideMainActivityModel(PreferenceService preferenceService) {
        MainActivityModel model = new MainActivityModel();
        model.setLoggedIn(preferenceService.isUserLoggedIn());
        return model;
    }

    @Provides
    @PerActivity
    MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenterImpl();
    }

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

    @Provides
    @PerActivity
    ShowCasePresenter provideShowCasePresenter() {
        return new ShowCasePresenterImpl();
    }

    @Provides
    @PerActivity
    ShowCaseView provideShowCaseView() {
        return new ShowCaseViewImpl();
    }
}
