package com.machinetest.app.ui.user_list;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.machinetest.app.data.api.ApiResponseHandler;
import com.machinetest.app.data.model.HeroesResponse;
import com.machinetest.app.data.model.User;
import com.machinetest.app.support.base.BaseViewModel;

import java.util.List;

public class MainViewModel extends BaseViewModel {

    private MutableLiveData<HeroesResponse> heroesResponseMutableLiveData ;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean login(String userName, String password) {
        return repository.login(userName, password);
    }

    public List<User> getList() {
        return repository.getList();
    }


//    public MutableLiveData<HeroesResponse> getHeroesObserver() {
//        return heroesResponseMutableLiveData;
//    }


    public LiveData<HeroesResponse> getHeroesObserver() {
        //if the list is null
        if (heroesResponseMutableLiveData == null) {
            heroesResponseMutableLiveData = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            fetchingHeroes();
        }

        //finally we will return the list
        return heroesResponseMutableLiveData;
    }


    public void fetchingHeroes() {
        repository.fetchHeroes(new ApiResponseHandler<HeroesResponse>() {
            @Override
            public void onSuccessResponse(HeroesResponse response) {
                heroesResponseMutableLiveData.setValue(response);
            }

            @Override
            public void onErrorResponse(String errorMessage) {
                heroesResponseMutableLiveData.setValue(null);

            }
        });
    }

}
