package com.playground.daggerplayground.data;

import com.playground.daggerplayground.data.common.Ingredient;

/**
 * Created by petnagy on 2017. 05. 02..
 */

public class Coffee implements Ingredient {

    private String coffeeVolume;

    public Coffee(String coffeeVolume) {
        this.coffeeVolume = coffeeVolume;
    }

    @Override
    public String getQuantity() {
        return coffeeVolume;
    }

    @Override
    public String getName() {
        return "coffee";
    }
}
