package com.playground.daggerplayground.pages.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.playground.daggerplayground.DaggerPlayGroundApplication;
import com.playground.daggerplayground.R;
import com.playground.daggerplayground.injection.component.ActivityComponent;
import com.playground.daggerplayground.injection.component.DaggerActivityComponent;
import com.playground.daggerplayground.injection.module.ActivityModule;
import com.playground.daggerplayground.pages.coffees.CoffeesActivity;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;
import com.playground.daggerplayground.pages.mainactivity.presenter.MainActivityPresenter;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityView;
import com.playground.daggerplayground.pages.mainactivity.view.OnUserActionCallback;
import com.playground.daggerplayground.services.preference.PreferenceService;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements OnUserActionCallback {

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        view.onCreate(this);
        presenter.attachView(view);
        presenter.showModel(model);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void onLoginPressed() {
        preferenceService.setUserLoggedIn(true);
        model.setLoggedIn(true);
        presenter.showModel(model);
    }

    @Override
    public void onLogOutPressed() {
        preferenceService.setUserLoggedIn(false);
        model.setLoggedIn(false);
        presenter.showModel(model);
    }

    @Override
    public void onGoCoffeePressed() {
        Intent coffeeLaunchIntent = CoffeesActivity.launchCoffeeActivity(this);
        startActivity(coffeeLaunchIntent);
    }

    @Override
    public void onGoFavoritePressed() {

    }
}
