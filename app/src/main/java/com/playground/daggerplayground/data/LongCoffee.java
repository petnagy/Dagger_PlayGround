package com.playground.daggerplayground.data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by petnagy on 2017. 05. 02..
 */

public class LongCoffee implements Drink {

    private List<Ingredient> ingredients;

    public LongCoffee(Coffee coffee, Water water, Milk milk) {
        ingredients = new LinkedList<>();
        ingredients.add(coffee);
        ingredients.add(water);
        ingredients.add(milk);
    }

    @Override
    public String createDrink() {
        StringBuilder drinkBuilder = new StringBuilder();
        for(Ingredient ingredient : ingredients) {
            drinkBuilder.append(ingredient.getQuantity()).append(" ").append(ingredient.getName()).append(" ");
        }
        return drinkBuilder.toString();
    }
}
