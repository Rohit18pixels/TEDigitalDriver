package com.machinetest.app.support.base;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

public abstract class BaseMvvmActivity<T extends BaseViewModel> extends BaseActivity {

    protected T mvvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.mvvm = createViewModel();
        super.onCreate(savedInstanceState);
    }

    private T createViewModel() {
        return new ViewModelProvider(this).get(createViewModelClass());
    }

    protected abstract Class<T> createViewModelClass();


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
