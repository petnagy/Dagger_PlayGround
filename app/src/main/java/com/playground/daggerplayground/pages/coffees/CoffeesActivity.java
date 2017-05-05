package com.playground.daggerplayground.pages.coffees;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.playground.daggerplayground.DaggerPlayGroundApplication;
import com.playground.daggerplayground.R;
import com.playground.daggerplayground.injection.component.ActivityComponent;
import com.playground.daggerplayground.injection.component.DaggerActivityComponent;
import com.playground.daggerplayground.injection.module.ActivityModule;
import com.playground.daggerplayground.pages.coffees.model.CoffeeActivityModel;
import com.playground.daggerplayground.pages.coffees.presenter.CoffeeActivityPresenter;
import com.playground.daggerplayground.pages.coffees.view.CoffeeActivityView;

import javax.inject.Inject;

/**
 * Created by petnagy on 2017. 05. 04..
 */

public class CoffeesActivity  extends AppCompatActivity {

    @Inject
    CoffeeActivityView view;

    @Inject
    CoffeeActivityPresenter presenter;

    @Inject
    CoffeeActivityModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffe_activity_layout);

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

    public static Intent launchCoffeeActivity(Context context) {
        return new Intent(context, CoffeesActivity.class);
    }
}
