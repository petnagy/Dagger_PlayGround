package com.playground.daggerplayground.injection.module;

import android.app.Activity;
import android.content.Context;

import com.playground.daggerplayground.data.Coffee;
import com.playground.daggerplayground.data.LongCoffee;
import com.playground.daggerplayground.data.Milk;
import com.playground.daggerplayground.data.ShortCoffee;
import com.playground.daggerplayground.data.Water;
import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;
import com.playground.daggerplayground.pages.mainactivity.presenter.MainActivityPresenter;
import com.playground.daggerplayground.pages.mainactivity.presenter.MainActivityPresenterImpl;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityView;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityViewImpl;
import com.playground.daggerplayground.services.preference.PreferenceService;

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
    MainActivityModel provideMainActivityModel(PreferenceService preferenceService) {
        MainActivityModel model = new MainActivityModel();
        model.setLoggedIn(preferenceService.isUserLoggedIn());
        return model;
    }

    @Provides
    MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenterImpl();
    }

//    @Provides
//    @PerActivity
//    MajorObject provideMajorObject() {
//        return new MajorObject();
//    }

}
