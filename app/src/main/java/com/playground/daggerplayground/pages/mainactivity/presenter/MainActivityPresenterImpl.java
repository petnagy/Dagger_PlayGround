package com.playground.daggerplayground.pages.mainactivity.presenter;

import com.playground.daggerplayground.common.view.View;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;
import com.playground.daggerplayground.pages.mainactivity.view.MainActivityView;

/**
 * Default implementation of MainActivityPresenter.
 * Created by petnagy on 2017. 05. 03..
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityView view;

    @Override
    public void attachView(View view) {
        this.view = (MainActivityView) view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void showModel(MainActivityModel model) {
        view.showModel(model);
    }
}
