package com.playground.daggerplayground.injection.module;

import com.playground.daggerplayground.data.Coffee;
import com.playground.daggerplayground.data.Ice;
import com.playground.daggerplayground.data.coffee.IceLongCoffee;
import com.playground.daggerplayground.data.coffee.LongCoffee;
import com.playground.daggerplayground.data.Milk;
import com.playground.daggerplayground.data.coffee.ShortCoffee;
import com.playground.daggerplayground.data.Water;
import com.playground.daggerplayground.data.common.Drink;

import java.util.ArrayList;
import java.util.List;

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

    @Provides
    @Named("COFFEE_LIST")
    List<Drink> provideCoffeeList(ShortCoffee shortCoffee, LongCoffee longCoffee,
                                  @Named("WITH_ICE") IceLongCoffee iceLongCoffeeWithIce,
                                  @Named("WITHOUT_ICE") IceLongCoffee iceLongCoffeeWithoutIce) {
        List<Drink> coffeeList = new ArrayList<>();
        coffeeList.add(shortCoffee);
        coffeeList.add(longCoffee);
        coffeeList.add(iceLongCoffeeWithIce);
        coffeeList.add(iceLongCoffeeWithoutIce);
        return coffeeList;
    }
}
