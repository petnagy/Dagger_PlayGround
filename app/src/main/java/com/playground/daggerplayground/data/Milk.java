package com.playground.daggerplayground.data;

import com.playground.daggerplayground.data.common.Ingredient;

/**
 * Ingredient Milk implementation.
 * Created by petnagy on 2017. 05. 02..
 */

public class Milk implements Ingredient {

    private String milkVolume;

    public Milk(String milkVolume) {
        this.milkVolume = milkVolume;
    }

    @Override
    public String getQuantity() {
        return milkVolume;
    }

    @Override
    public String getName() {
        return "milk";
    }
}
