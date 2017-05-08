package com.playground.daggerplayground.pages.showcase.presenter;

import com.playground.daggerplayground.common.view.View;
import com.playground.daggerplayground.pages.showcase.model.ShowCaseModel;
import com.playground.daggerplayground.pages.showcase.view.ShowCaseView;

/**
 * Created by petnagy on 2017. 05. 08..
 */

public class ShowCasePresenterImpl implements ShowCasePresenter {

    private ShowCaseView view;

    @Override
    public void attachView(View view) {
        this.view = (ShowCaseView) view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void showModel(ShowCaseModel model) {
        model.getContextValue();
        view.showModel(model);
    }
}
