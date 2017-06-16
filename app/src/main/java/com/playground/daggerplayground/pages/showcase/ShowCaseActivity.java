package com.playground.daggerplayground.pages.showcase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.playground.daggerplayground.R;
import com.playground.daggerplayground.pages.showcase.model.ShowCaseModel;
import com.playground.daggerplayground.pages.showcase.presenter.ShowCasePresenter;
import com.playground.daggerplayground.pages.showcase.view.ShowCaseCallback;
import com.playground.daggerplayground.pages.showcase.view.ShowCaseView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Activity where there are contructor, method and field injection.
 * Created by petnagy on 2017. 05. 08..
 */

public class ShowCaseActivity extends AppCompatActivity implements ShowCaseCallback {

    private static final String TAG = ShowCaseActivity.class.getSimpleName();

    @Inject
    ShowCaseView view;

    @Inject
    ShowCasePresenter presenter;

    @Inject
    ShowCaseModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_case_activity_layout);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, this.toString());

        view.onCreate(this);
        presenter.attachView(view);
        presenter.showModel(model);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    public static Intent launchActivity(Context context) {
        return new Intent(context, ShowCaseActivity.class);
    }

    @Override
    public void onGetLazyInjectedObject() {
        model.callLazyShortCoffeeGet();
        presenter.showModel(model);
    }

    @Override
    public void onGetProvider() {
        model.callProviderShortCoffee();
        presenter.showModel(model);
    }
}
