package com.playground.daggerplayground.pages.mainactivity.view;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.playground.daggerplayground.R;
import com.playground.daggerplayground.pages.mainactivity.model.MainActivityModel;

/**
 * Created by petnagy on 2017. 05. 03..
 */

public class MainActivityViewImpl implements MainActivityView {

    private final static String USER_IS_LOGGED_IN = "User is logged in";

    private final static String USER_IS_NOT_LOGGED_IN = "User is NOT logged in";

    private Button btnShowCoffee;

    private Button btnShowFavorite;

    private Button btnLogin;

    private Button btnLogout;

    private TextView userLoginState;

    private OnUserActionCallback callback;

    @Override
    public void onCreate(Activity activity) {
        callback = (OnUserActionCallback) activity;
        btnShowCoffee = (Button) activity.findViewById(R.id.btn_coffee);
        btnShowFavorite = (Button) activity.findViewById(R.id.btn_favorite);
        btnLogin = (Button) activity.findViewById(R.id.btn_login);
        btnLogout = (Button) activity.findViewById(R.id.btn_logout);
        userLoginState = (TextView) activity.findViewById(R.id.user_login_state_text);

        btnShowCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onGoCoffeePressed();
            }
        });

        btnShowFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onGoFavoritePressed();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onLoginPressed();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onLogOutPressed();
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
        userLoginState.setText(model.isLoggedIn() ? USER_IS_LOGGED_IN : USER_IS_NOT_LOGGED_IN);
    }
}
