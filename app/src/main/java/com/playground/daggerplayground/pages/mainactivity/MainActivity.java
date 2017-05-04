package com.playground.daggerplayground.pages.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.playground.daggerplayground.DaggerPlayGroundApplication;
import com.playground.daggerplayground.R;
import com.playground.daggerplayground.data.IceLongCoffee;
import com.playground.daggerplayground.data.LongCoffee;
import com.playground.daggerplayground.data.MajorObject;
import com.playground.daggerplayground.data.ShortCoffee;
import com.playground.daggerplayground.injection.component.ActivityComponent;
import com.playground.daggerplayground.injection.component.DaggerActivityComponent;
import com.playground.daggerplayground.injection.module.ActivityModule;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;
import com.playground.daggerplayground.pages.mainactivity.presenter.MainActivityPresenter;
import com.playground.daggerplayground.pages.mainactivity.presenter.MainActivityPresenterImpl;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityView;
import com.playground.daggerplayground.pages.mainactivity.view.OnUserActionCallback;
import com.playground.daggerplayground.services.preference.PreferenceService;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity implements OnUserActionCallback {

    @Inject
    MajorObject majorObject;

    @Inject
    ShortCoffee shortCoffee;

    @Inject
    LongCoffee longCoffee;

    @Inject
    @Named("WITH_ICE")
    IceLongCoffee iceLongCoffee;

    @Inject
    @Named("WITHOUT_ICE")
    IceLongCoffee iceLongCoffeeWithoutIce;

    @Inject
    MainActivityView view;

    @Inject
    MainActivityPresenter presenter;

    @Inject
    PreferenceService preferenceService;

    @Inject
    MainActivityModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityComponent activityComponent= DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(DaggerPlayGroundApplication.get(this).getComponent())
                .build();
        activityComponent.inject(this);

        view.onCreate(this);
        presenter.attachView(view);
        presenter.loadUserData(model);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        majorObject.logObjectDetails();
        Log.d("MainActivity", shortCoffee.createDrink());
        Log.d("MainActivity", longCoffee.createDrink());
        Log.d("MainActivity", iceLongCoffee.createDrink());
        Log.d("MainActivity", iceLongCoffeeWithoutIce.createDrink());
    }

    @Override
    public void onLoginPressed() {
        preferenceService.setUserLoggedIn(true);
        model.setLoggedIn(true);
        presenter.loadUserData(model);
    }

    @Override
    public void onLogOutPressed() {
        preferenceService.setUserLoggedIn(false);
        model.setLoggedIn(false);
        presenter.loadUserData(model);
    }

    @Override
    public void onGoCoffeePressed() {

    }

    @Override
    public void onGoFavoritePressed() {

    }
}
