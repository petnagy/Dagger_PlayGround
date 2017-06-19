package com.playground.daggerplayground.injection.module;

import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;
import com.playground.daggerplayground.pages.mainactivity.presenter.MainActivityPresenter;
import com.playground.daggerplayground.pages.mainactivity.presenter.MainActivityPresenterImpl;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityView;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityViewImpl;
import com.playground.daggerplayground.services.preference.PreferenceService;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module for MainActivity.
 * Created by petnagy on 2017. 06. 16..
 */
@Module
public class MainActivityModule {

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

}

