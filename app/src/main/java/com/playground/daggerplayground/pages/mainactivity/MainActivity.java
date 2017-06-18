package com.playground.daggerplayground.pages.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.playground.daggerplayground.R;
import com.playground.daggerplayground.pages.coffees.CoffeeActivity;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;
import com.playground.daggerplayground.pages.mainactivity.presenter.MainActivityPresenter;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityView;
import com.playground.daggerplayground.pages.mainactivity.view.OnUserActionCallback;
import com.playground.daggerplayground.pages.showcase.ShowCaseActivity;
import com.playground.daggerplayground.services.preference.PreferenceService;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * MainActivity.
 */
public class MainActivity extends DaggerAppCompatActivity implements OnUserActionCallback {

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
        Intent coffeeLaunchIntent = CoffeeActivity.launchCoffeeActivity(this);
        startActivity(coffeeLaunchIntent);
    }

    @Override
    public void onGoShowCase() {
        Intent launchIntent = ShowCaseActivity.launchActivity(this);
        startActivity(launchIntent);
    }
}
