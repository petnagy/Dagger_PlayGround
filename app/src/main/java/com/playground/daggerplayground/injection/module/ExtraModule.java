package com.playground.daggerplayground.injection.module;

import com.playground.daggerplayground.data.Ice;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by petnagy on 2017. 05. 02..
 */
@Module
public class ExtraModule {

    @Provides
    @Named("TWO_CUBES_ICE")
    Ice provideTwoCubesIce() {
       return new Ice("add 2 ice cubes");
    }

}
