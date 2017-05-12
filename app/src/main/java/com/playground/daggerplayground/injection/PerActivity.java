package com.playground.daggerplayground.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * PerActivity annotation.
 * Created by petnagy on 2017. 04. 30..
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
