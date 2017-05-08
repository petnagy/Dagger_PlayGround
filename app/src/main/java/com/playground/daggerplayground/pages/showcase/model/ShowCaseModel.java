package com.playground.daggerplayground.pages.showcase.model;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by petnagy on 2017. 05. 08..
 */

public class ShowCaseModel {

    @Inject
    Context context;

    @Inject
    public ShowCaseModel() {
    }

    public String getContextValue() {
        return context.toString();
    }

}
