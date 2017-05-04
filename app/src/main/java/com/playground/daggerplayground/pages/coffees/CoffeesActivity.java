package com.playground.daggerplayground.pages.coffees;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by petnagy on 2017. 05. 04..
 */

public class CoffeesActivity  extends AppCompatActivity {


    public static Intent launchCoffeeActivity(Context context) {
        return new Intent(context, CoffeesActivity.class); 
    }
}
