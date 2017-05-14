package com.playground.daggerplayground.pages.showcase.view;

/**
 * Callback to communicate between View and Presenter.
 * Created by petnagy on 2017. 05. 14..
 */

public interface ShowCaseCallback {

    void onGetLazyInjectedObject();

    void onGetProvider();
}
