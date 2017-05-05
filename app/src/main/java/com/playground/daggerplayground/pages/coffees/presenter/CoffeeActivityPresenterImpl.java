package com.playground.daggerplayground.pages.coffees.presenter;

import com.playground.daggerplayground.common.view.View;
import com.playground.daggerplayground.pages.coffees.model.CoffeeActivityModel;
import com.playground.daggerplayground.pages.coffees.view.CoffeeActivityView;

/**
 * Created by petnagy on 2017. 05. 05..
 */

public class CoffeeActivityPresenterImpl implements CoffeeActivityPresenter {

    private CoffeeActivityView view;

    @Override
    public void attachView(View view) {
        this.view = (CoffeeActivityView) view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void showModel(CoffeeActivityModel model) {
        view.showModel(model);
    }
}
