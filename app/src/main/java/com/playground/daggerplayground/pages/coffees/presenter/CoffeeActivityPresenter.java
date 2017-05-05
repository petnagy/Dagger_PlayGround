package com.playground.daggerplayground.pages.coffees.presenter;

import com.playground.daggerplayground.common.presenter.Presenter;
import com.playground.daggerplayground.pages.coffees.model.CoffeeActivityModel;

/**
 * Created by petnagy on 2017. 05. 05..
 */

public interface CoffeeActivityPresenter extends Presenter {

    void showModel(CoffeeActivityModel model);
}
