package com.playground.daggerplayground.common.presenter;

import com.playground.daggerplayground.common.view.View;

/**
 * General Presenter interface.
 * Created by petnagy on 2017. 05. 03..
 */

public interface Presenter {

    void attachView(View view);

    void detachView();
}
