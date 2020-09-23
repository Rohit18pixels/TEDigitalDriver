package com.tedigital.driver.app.ui.auth.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.tedigital.driver.app.data.api.ApiResponseHandler;
import com.tedigital.driver.app.data.model.authmodel.RegistrationResonse;
import com.tedigital.driver.app.data.repository.authrepo.RegistrationRepo;
import com.tedigital.driver.app.support.base.BaseViewModel;

public class RegistrationFragmentViewModel extends BaseViewModel {


    private final MutableLiveData<RegistrationResonse> registrationResonseMutableLiveData;
    RegistrationRepo registrationRepo;


    public RegistrationFragmentViewModel() {

        registrationRepo = new RegistrationRepo();
        registrationResonseMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<RegistrationResonse> getRegistrationResonseMutableLiveData() {
        return registrationResonseMutableLiveData;
    }

    public void executeUpdateProfile(String s, JsonObject jsonObject) {
        registrationRepo.getUpdateProfile(s, jsonObject, new ApiResponseHandler<RegistrationResonse>() {
            @Override
            public void onSuccessResponse(RegistrationResonse response) {
                getRegistrationResonseMutableLiveData().setValue(response);
            }

            @Override
            public void onErrorResponse(String errorMessage) {
                getRegistrationResonseMutableLiveData().setValue(null);

            }
        });
    }
}
