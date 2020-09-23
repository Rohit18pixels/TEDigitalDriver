package com.machinetest.app.ui.splash;


import android.app.Application;

import androidx.annotation.NonNull;

import com.machinetest.app.support.Constants;
import com.machinetest.app.support.CustomPerference;
import com.machinetest.app.support.base.BaseViewModel;

public class SplashViewModel extends BaseViewModel {

    public SplashViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean isUserLogged(){
        return         CustomPerference.getBoolean(mContext, Constants.ISLOGIN);

    }
}
