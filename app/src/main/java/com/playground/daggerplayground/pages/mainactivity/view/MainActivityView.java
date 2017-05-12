package com.playground.daggerplayground.pages.mainactivity.view;

import com.playground.daggerplayground.common.view.View;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;

/**
 * view of MainActivity.
 * Created by petnagy on 2017. 05. 03..
 */

public interface MainActivityView extends View {

    void showModel(MainActivityModel model);
}
