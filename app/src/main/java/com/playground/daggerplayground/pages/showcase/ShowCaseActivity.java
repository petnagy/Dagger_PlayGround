package com.playground.daggerplayground.pages.showcase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.playground.daggerplayground.DaggerPlayGroundApplication;
import com.playground.daggerplayground.R;
import com.playground.daggerplayground.injection.component.ActivityComponent;
import com.playground.daggerplayground.injection.component.DaggerActivityComponent;
import com.playground.daggerplayground.injection.module.ActivityModule;
import com.playground.daggerplayground.pages.showcase.model.ShowCaseModel;
import com.playground.daggerplayground.pages.showcase.presenter.ShowCasePresenter;
import com.playground.daggerplayground.pages.showcase.view.ShowCaseView;

import javax.inject.Inject;

/**
 * Created by petnagy on 2017. 05. 08..
 */

public class ShowCaseActivity extends AppCompatActivity {

    private static final String TAG = ShowCaseActivity.class.getSimpleName();

    @Inject
    ShowCaseView view;

    @Inject
    ShowCasePresenter presenter;

    @Inject
    ShowCaseModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_case_activity_layout);
        ActivityComponent activityComponent= DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(DaggerPlayGroundApplication.get(this).getComponent())
                .build();
        activityComponent.inject(this);
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

}
