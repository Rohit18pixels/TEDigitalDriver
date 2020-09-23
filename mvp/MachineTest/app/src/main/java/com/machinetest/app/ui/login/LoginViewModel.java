package com.machinetest.app.ui.login;


import android.app.Application;

import androidx.annotation.NonNull;

import com.machinetest.app.support.Constants;
import com.machinetest.app.support.CustomPerference;
import com.machinetest.app.support.base.BaseViewModel;

public class LoginViewModel extends BaseViewModel {

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean login(String userName, String password)
    {
      return   repository.login(userName, password);
    }

}
