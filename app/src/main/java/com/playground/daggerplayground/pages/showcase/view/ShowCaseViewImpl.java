package com.playground.daggerplayground.pages.showcase.view;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.playground.daggerplayground.R;
import com.playground.daggerplayground.pages.showcase.model.ShowCaseModel;

/**
 * Default implementation of ShowCaseView.
 * Created by petnagy on 2017. 05. 08..
 */

public class ShowCaseViewImpl implements ShowCaseView {

    private String TAG = ShowCaseViewImpl.class.getSimpleName();

    private TextView txtModelFieldInjectedProp;
    private TextView txtModelMethodInjectedCoffee;
    private Button btnLoadLazyObj;
    private TextView txtLazyInjectHeaderText;
    private TextView txtLazyInjectObject;
    private ShowCaseCallback callback;
    private Button btnLoadProvider;
    private TextView txtProvidedObj;

    @Override
    public void onCreate(Activity activity) {
        callback = (ShowCaseCallback) activity;
        txtModelFieldInjectedProp = (TextView) activity.findViewById(R.id.txt_common_field_injected_model_prop);
        txtModelMethodInjectedCoffee = (TextView) activity.findViewById(R.id.txt_coffee_with_method_injection);
        btnLoadLazyObj = (Button) activity.findViewById(R.id.btn_load_lazy_obj);
        txtLazyInjectHeaderText = (TextView) activity.findViewById(R.id.txt_lazy_inject_label);
        txtLazyInjectObject = (TextView) activity.findViewById(R.id.txt_lazy_inject);
        btnLoadProvider = (Button) activity.findViewById(R.id.btn_load_provider_obj);
        txtProvidedObj = (TextView) activity.findViewById(R.id.txt_provider_obj);

        btnLoadLazyObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onGetLazyInjectedObject();
            }
        });

        btnLoadProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onGetProvider();
            }
        });
    }

    @Override
    public void showModel(ShowCaseModel model) {
        Log.d(TAG, model.getContextValue());
        txtModelFieldInjectedProp.setText(model.getContextValue());
        txtModelMethodInjectedCoffee.setText(model.getMyCoffee());
        txtLazyInjectHeaderText.setText("Lazy Object Injected: " + model.getLazyObject());
        txtLazyInjectObject.setText(model.getLazyShortCoffee());
        txtProvidedObj.setText(model.getProvidedObj());
    }

}
