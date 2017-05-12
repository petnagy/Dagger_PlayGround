package com.playground.daggerplayground.services.preference;

/**
 * Preference Service.
 * Created by petnagy on 2017. 04. 30..
 */

public interface PreferenceService {

    boolean isUserLoggedIn();

    void setUserLoggedIn(boolean b);
}
