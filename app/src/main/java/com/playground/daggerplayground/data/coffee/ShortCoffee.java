package com.playground.daggerplayground.data.coffee;

import com.playground.daggerplayground.data.Coffee;
import com.playground.daggerplayground.data.common.Drink;
import com.playground.daggerplayground.data.common.Ingredient;

/**
 * Shot Coffee implementation.
 * Created by petnagy on 2017. 05. 02..
 */

public class ShortCoffee implements Drink {

    private Ingredient coffee;

    public ShortCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String createDrink() {
        return coffee.getQuantity() + " " + coffee.getName();
    }

    @Override
    public String getDrinkiName() {
        return "Short Coffee";
    }
}
