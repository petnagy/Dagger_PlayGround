package com.playground.daggerplayground.pages.coffees;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.playground.daggerplayground.R;
import com.playground.daggerplayground.pages.coffees.model.CoffeeActivityModel;
import com.playground.daggerplayground.pages.coffees.presenter.CoffeeActivityPresenter;
import com.playground.daggerplayground.pages.coffees.view.CoffeeActivityView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * CoffeeActivity with list of coffees.
 * Created by petnagy on 2017. 05. 04..
 */
public class CoffeeActivity extends AppCompatActivity {

    @Inject
    CoffeeActivityView view;

    @Inject
    CoffeeActivityPresenter presenter;

    @Inject
    CoffeeActivityModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffe_activity_layout);
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
        return new Intent(context, CoffeeActivity.class);
    }
}
