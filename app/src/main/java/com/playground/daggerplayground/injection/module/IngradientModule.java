package com.playground.daggerplayground.injection.module;

import com.playground.daggerplayground.data.Coffee;
import com.playground.daggerplayground.data.Milk;
import com.playground.daggerplayground.data.Water;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by petnagy on 2017. 05. 02..
 */
@Module
public class IngradientModule {

    @Provides
    @Named("SMALL_COFFEE")
    Coffee provideSmallCoffee() {
        return new Coffee("1dl");
    }

    @Provides
    @Named("BIG_COFFEE")
    Coffee provideBigCoffee() {
        return new Coffee("3dl");
    }

    @Provides
    @Named("SMALL_COLD_WATER")
    Water provideColdWater() {
        return new Water("1dl", "cold water");
    }

    @Provides
    @Named("SMALL_MILK")
    Milk provideSmallMilk() {
        return new Milk("1dl");
    }

}
