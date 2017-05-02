package com.playground.daggerplayground.data;

/**
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
}
