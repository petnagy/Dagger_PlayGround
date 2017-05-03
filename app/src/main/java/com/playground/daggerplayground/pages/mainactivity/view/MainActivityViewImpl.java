package com.playground.daggerplayground.pages.mainactivity.view;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.playground.daggerplayground.R;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;

/**
 * Created by petnagy on 2017. 05. 03..
 */

public class MainActivityViewImpl implements MainActivityView {

    private Button btnShowCoffee;

    private Button btnShowFavorite;

    private Button btnLogin;

    private Button btnLogout;

    @Override
    public void onCreate(Activity activity) {
        btnShowCoffee = (Button) activity.findViewById(R.id.btn_coffee);
        btnShowFavorite = (Button) activity.findViewById(R.id.btn_favorite);
        btnLogin = (Button) activity.findViewById(R.id.btn_login);
        btnLogout = (Button) activity.findViewById(R.id.btn_logout);

        btnShowCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnShowFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnShowCoffee.setVisibility(View.GONE);
        btnShowFavorite.setVisibility(View.GONE);
        btnLogin.setVisibility(View.GONE);
        btnLogout.setVisibility(View.GONE);
    }

    @Override
    public void showModel(MainActivityModel model) {
        btnShowCoffee.setVisibility(View.VISIBLE);
        btnShowFavorite.setVisibility(View.VISIBLE);
        btnLogin.setVisibility(model.isLoggedIn() ? View.GONE : View.VISIBLE);
        btnLogout.setVisibility(model.isLoggedIn() ? View.VISIBLE : View.GONE);
    }
}
