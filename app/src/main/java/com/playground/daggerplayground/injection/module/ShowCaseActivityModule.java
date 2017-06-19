package com.playground.daggerplayground.injection.module;

import android.content.Context;

import com.playground.daggerplayground.injection.PerActivity;
import com.playground.daggerplayground.pages.showcase.ShowCaseActivity;
import com.playground.daggerplayground.pages.showcase.presenter.ShowCasePresenter;
import com.playground.daggerplayground.pages.showcase.presenter.ShowCasePresenterImpl;
import com.playground.daggerplayground.pages.showcase.view.ShowCaseView;
import com.playground.daggerplayground.pages.showcase.view.ShowCaseViewImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module for MainActivity.
 * Created by petnagy on 2017. 06. 16..
 */
@Module
public abstract class ShowCaseActivityModule {

    @Binds
    abstract Context context(ShowCaseActivity activity);

    @Provides
    @PerActivity
    static ShowCasePresenter provideShowCasePresenter() {
        return new ShowCasePresenterImpl();
    }

    @Provides
    @PerActivity
    static ShowCaseView provideShowCaseView() {
        return new ShowCaseViewImpl();
    }

}

