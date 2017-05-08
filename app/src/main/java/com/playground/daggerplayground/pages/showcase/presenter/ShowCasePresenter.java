package com.playground.daggerplayground.pages.showcase.presenter;

import com.playground.daggerplayground.common.presenter.Presenter;
import com.playground.daggerplayground.pages.showcase.model.ShowCaseModel;

/**
 * Created by petnagy on 2017. 05. 08..
 */

public interface ShowCasePresenter extends Presenter {

    void showModel(ShowCaseModel model);
}
