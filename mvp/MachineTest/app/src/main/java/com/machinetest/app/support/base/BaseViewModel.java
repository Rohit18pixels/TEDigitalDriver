package com.machinetest.app.support.base;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.machinetest.app.data.repository.UserRepository;

public abstract class BaseViewModel extends AndroidViewModel {

    protected final UserRepository repository;
    protected final Context mContext;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mContext = application.getApplicationContext();
        repository = new UserRepository(mContext);
    }
}
