package com.playground.daggerplayground.injection.module;

import android.app.Activity;
import android.content.Context;

import com.playground.daggerplayground.data.Coffee;
import com.playground.daggerplayground.data.LongCoffee;
import com.playground.daggerplayground.data.Milk;
import com.playground.daggerplayground.data.ShortCoffee;
import com.playground.daggerplayground.data.Water;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by petnagy on 2017. 04. 30..
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

//    @Provides
//    @PerActivity
//    MajorObject provideMajorObject() {
//        return new MajorObject();
//    }

}
