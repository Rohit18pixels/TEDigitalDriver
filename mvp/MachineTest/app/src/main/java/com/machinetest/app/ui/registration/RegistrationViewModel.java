package com.machinetest.app.ui.registration;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.machinetest.app.data.api.ApiResponseHandler;
import com.machinetest.app.data.model.HeroesResponse;
import com.machinetest.app.data.model.User;
import com.machinetest.app.support.base.BaseViewModel;

import java.util.List;

public class RegistrationViewModel extends BaseViewModel {



    public RegistrationViewModel(@NonNull Application application) {
        super(application);
    }

    public Long registration(String _username, String _fullname, String _phone, String _dob, String _gender, String password)
    {
       return repository.registration(_username, _fullname, _phone,_dob, _gender, password);
    }

    public List<User> getList(){
        return repository.getList();
    }



}
