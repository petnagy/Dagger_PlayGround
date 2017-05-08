package com.playground.daggerplayground.pages.showcase.view;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.playground.daggerplayground.R;
import com.playground.daggerplayground.pages.showcase.model.ShowCaseModel;

/**
 * Created by petnagy on 2017. 05. 08..
 */

public class ShowCaseViewImpl implements ShowCaseView {

    private String TAG = ShowCaseViewImpl.class.getSimpleName();

    private TextView txtModelFieldInjectedProp;

    @Override
    public void onCreate(Activity activity) {
        txtModelFieldInjectedProp = (TextView) activity.findViewById(R.id.txt_common_field_injected_model_prop);
    }

    @Override
    public void showModel(ShowCaseModel model) {
        Log.d(TAG, model.getContextValue());
        txtModelFieldInjectedProp.setText(model.getContextValue());
    }

}
