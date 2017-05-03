package com.playground.daggerplayground.pages.mainactivity.presenter;

import com.playground.daggerplayground.common.view.View;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityView;

/**
 * Created by petnagy on 2017. 05. 03..
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityView view;

    private MainActivityModel model;

    @Override
    public void attachView(View view) {
        this.view = (MainActivityView) view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void loadUserData(MainActivityModel model) {
        this.model = model;
        view.showModel(model);
    }
}
