package com.jobportalemployer.app.ui.main.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jobportalemployer.app.data.api.ApiResponseHandler;
import com.jobportalemployer.app.data.model.LoginResponce;
import com.jobportalemployer.app.data.repository.Repository;

public class LoginViewModel extends AndroidViewModel {

    private Repository loginRepository;
    private final MutableLiveData<LoginResponce> loginResponceLiveData = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    public void init() {
        loginRepository = new Repository();
    }

    public MutableLiveData<LoginResponce> getLoginObserber()
    {
        return loginResponceLiveData;
    }

    public void login(String username, String password) {
        loginRepository.getLogingBody(username,password, new ApiResponseHandler<LoginResponce>() {
            @Override
            public void onSuccessResponse(LoginResponce response) {
                loginResponceLiveData.postValue(response);
            }

            @Override
            public void onErrorResponse(String errorMessage) {
                loginResponceLiveData.postValue(null);

            }
        });

    }



}
