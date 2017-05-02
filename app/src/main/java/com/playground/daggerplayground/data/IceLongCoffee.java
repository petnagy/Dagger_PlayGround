package com.playground.daggerplayground.data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by petnagy on 2017. 05. 02..
 */

public class IceLongCoffee implements Drink {

    private List<Ingredient> ingredients;

    private Extra ice;

    public IceLongCoffee(Coffee coffee, Milk milk) {
        ingredients = new LinkedList<>();
        ingredients.add(coffee);
        ingredients.add(milk);
    }

    public void addExtra(Ice ice) {
        this.ice = ice;
    }

    @Override
    public String createDrink() {
        StringBuilder coffeeBuilder = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            coffeeBuilder.append(ingredient.getQuantity()).append(" ").append(ingredient.getName()).append(" ");
        }

        if (ice != null) {
            coffeeBuilder.append(ice.getMode());
        }
        return coffeeBuilder.toString();
    }
}
