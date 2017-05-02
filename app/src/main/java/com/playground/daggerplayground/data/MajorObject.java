package com.playground.daggerplayground.data;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by petnagy on 2017. 05. 01..
 */

public class MajorObject {

    private static final String TAG = MajorObject.class.getSimpleName();

    @Inject
    Context context;

    @Inject
    public MajorObject(Context context, Activity activity) {
        Log.d(TAG, "Constructor");
        Log.d(TAG, context.toString());
        Log.d(TAG, activity.toString());
    }

    public void setContext(Context context) {
        Log.d(TAG, "Setter");
        //this.context = context;
    }

    public void logObjectDetails() {
        Log.d(TAG, context.toString());
    }

}
