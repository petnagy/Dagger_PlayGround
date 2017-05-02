package com.playground.daggerplayground.injection.module;

import com.playground.daggerplayground.data.Coffee;
import com.playground.daggerplayground.data.Ice;
import com.playground.daggerplayground.data.IceLongCoffee;
import com.playground.daggerplayground.data.LongCoffee;
import com.playground.daggerplayground.data.Milk;
import com.playground.daggerplayground.data.ShortCoffee;
import com.playground.daggerplayground.data.Water;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by petnagy on 2017. 05. 02..
 */
@Module
public class CoffeeModule {

    @Provides
    ShortCoffee provideShortCoffee(@Named("SMALL_COFFEE") Coffee coffee) {
        return new ShortCoffee(coffee);
    }

    @Provides
    LongCoffee provideLongCoffee(@Named("BIG_COFFEE") Coffee coffee, @Named("SMALL_COLD_WATER") Water water,
                                 @Named("SMALL_MILK") Milk milk) {
        return new LongCoffee(coffee, water, milk);
    }

    @Provides
    @Named("WITH_ICE")
    IceLongCoffee provideIceLongCoffee(@Named("BIG_COFFEE") Coffee coffee, @Named("SMALL_MILK") Milk milk,
                                       @Named("TWO_CUBES_ICE") Ice ice) {
        IceLongCoffee iceLongCoffee = new IceLongCoffee(coffee, milk);
        iceLongCoffee.addExtra(ice);
        return iceLongCoffee;
    }

    @Provides
    @Named("WITHOUT_ICE")
    IceLongCoffee proviceIceLongCoffeeWithoutIce(@Named("BIG_COFFEE") Coffee coffee, @Named("SMALL_MILK") Milk milk) {
        return new IceLongCoffee(coffee, milk);
    }
}
