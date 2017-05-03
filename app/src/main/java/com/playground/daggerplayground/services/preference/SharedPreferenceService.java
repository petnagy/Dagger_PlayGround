package com.playground.daggerplayground.services.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.playground.daggerplayground.injection.ApplicationContext;

import javax.inject.Inject;

/**
 * Created by petnagy on 2017. 04. 30..
 */

public class SharedPreferenceService implements PreferenceService {

    private static final String SHARED_PREFERENCE = "SharedPreference";

    private static final String USER_LOGGED_IN = "userLoggedIn";

    private SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferenceService(@ApplicationContext Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

    @Override
    public boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean(USER_LOGGED_IN, false);
    }
}
