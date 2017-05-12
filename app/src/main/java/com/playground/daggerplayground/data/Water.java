package com.playground.daggerplayground.data;

import com.playground.daggerplayground.data.common.Ingredient;

/**
 * Ingredient Water implementation.
 * Created by petnagy on 2017. 05. 02..
 */

public class Water implements Ingredient {

    private String waterVolume;

    private String name;

    public Water(String waterVolume, String name) {
        this.waterVolume = waterVolume;
        this.name = name;
    }

    @Override
    public String getQuantity() {
        return waterVolume;
    }

    @Override
    public String getName() {
        return name;
    }
}
