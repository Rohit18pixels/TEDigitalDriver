package com.machinetest.app.support.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carls_configure(savedInstanceState);
        carls_bindViews();
    }

    protected void carls_configure(@Nullable Bundle savedInstanceState) {

    }

    protected abstract void carls_bindViews();

    /*activities*/
    protected void carls_startActivity(Class<? extends BaseActivity> activityClass) {
        carls_startActivity(activityClass, null, -1);
    }

    protected void carls_startActivity(Class<? extends BaseActivity> activityClass, Bundle bundle) {
        carls_startActivity(activityClass, bundle, -1);
    }

    protected void carls_startActivity(Class<? extends BaseActivity> activityClass, Bundle bundle, int flags) {
        Intent intent = new Intent(this, activityClass);
        if (flags != -1)
            intent.setFlags(flags);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivity(intent);
    }


}