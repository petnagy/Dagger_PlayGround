package com.playground.daggerplayground.pages.coffees.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.playground.daggerplayground.R;
import com.playground.daggerplayground.pages.coffees.model.CoffeeActivityModel;

/**
 * Created by petnagy on 2017. 05. 05..
 */

public class CoffeeActivityViewImpl implements CoffeeActivityView {

    private final static String USER_IS_LOGGED_IN = "User is logged in";

    private final static String USER_IS_NOT_LOGGED_IN = "User is NOT logged in";

    private TextView userStateTxt;

    private RecyclerView coffeeList;

    @Override
    public void onCreate(Activity activity) {
        userStateTxt = (TextView) activity.findViewById(R.id.coffee_user_state);
        coffeeList = (RecyclerView) activity.findViewById(R.id.coffee_list);
    }

    @Override
    public void showModel(CoffeeActivityModel model) {
        userStateTxt.setText(model.isLoggedIn() ? USER_IS_LOGGED_IN : USER_IS_NOT_LOGGED_IN);
    }
}
