package com.playground.daggerplayground.pages.coffees.model;

import com.playground.daggerplayground.data.common.Drink;

import java.util.List;

/**
 * Created by petnagy on 2017. 05. 05..
 */

public class CoffeeActivityModel {

    private boolean isLoggedIn;

    private List<Drink> coffeeList;

    private Drink userFavorite;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public List<Drink> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(List<Drink> coffeeList) {
        this.coffeeList = coffeeList;
    }

    public Drink getUserFavorite() {
        return userFavorite;
    }

    public void setUserFavorite(Drink userFavorite) {
        this.userFavorite = userFavorite;
    }
}
