package com.playground.daggerplayground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.playground.daggerplayground.data.IceLongCoffee;
import com.playground.daggerplayground.data.LongCoffee;
import com.playground.daggerplayground.data.MajorObject;
import com.playground.daggerplayground.data.ShortCoffee;
import com.playground.daggerplayground.injection.component.ActivityComponent;
import com.playground.daggerplayground.injection.component.DaggerActivityComponent;
import com.playground.daggerplayground.injection.module.ActivityModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Inject
    MajorObject majorObject;

    @Inject
    ShortCoffee shortCoffee;

    @Inject
    LongCoffee longCoffee;

    @Inject
    @Named("WITH_ICE")
    IceLongCoffee iceLongCoffee;

    @Inject
    @Named("WITHOUT_ICE")
    IceLongCoffee iceLongCoffeeWithoutIce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityComponent activityComponent= DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(DaggerPlayGroundApplication.get(this).getComponent())
                .build();
        activityComponent.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        majorObject.logObjectDetails();
        Log.d("MainActivity", shortCoffee.createDrink());
        Log.d("MainActivity", longCoffee.createDrink());
        Log.d("MainActivity", iceLongCoffee.createDrink());
        Log.d("MainActivity", iceLongCoffeeWithoutIce.createDrink());
    }
}
