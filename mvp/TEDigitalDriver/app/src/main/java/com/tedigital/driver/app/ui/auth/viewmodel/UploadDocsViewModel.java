package com.tedigital.driver.app.ui.auth.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.tedigital.driver.app.data.api.ApiResponseHandler;
import com.tedigital.driver.app.data.model.authmodel.RegistrationResonse;
import com.tedigital.driver.app.data.model.authmodel.UploadFileResponse;
import com.tedigital.driver.app.data.repository.authrepo.UploadDocsRepository;
import com.tedigital.driver.app.support.base.BaseViewModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class UploadDocsViewModel extends BaseViewModel {

    private final MutableLiveData<UploadFileResponse> uploadFileResponseMutableLiveData;
    private final MutableLiveData<RegistrationResonse> registrationResonseMutableLiveData;
    UploadDocsRepository repository;

    public UploadDocsViewModel() {
        uploadFileResponseMutableLiveData = new MutableLiveData<>();
        registrationResonseMutableLiveData = new MutableLiveData<>();
        repository = new UploadDocsRepository();
    }

    public MutableLiveData<UploadFileResponse> getUploadFileResponseMutableLiveData()
    {
        return uploadFileResponseMutableLiveData;
    }

    public void executeUploadFile(MultipartBody.Part file)
    {
        repository.uploadImageFile(file, new ApiResponseHandler<UploadFileResponse>(){

            @Override
            public void onSuccessResponse(UploadFileResponse response) {
                uploadFileResponseMutableLiveData.setValue(response);
            }

            @Override
            public void onErrorResponse(String errorMessage) {

                setError(errorMessage);
            }
        });
    }


    public MutableLiveData<RegistrationResonse> getRegistrationResonseMutableLiveData() {
        return registrationResonseMutableLiveData;
    }

    public void executeUpdateProfile(String s, JsonObject jsonObject) {
        repository.getUpdateProfile(s, jsonObject, new ApiResponseHandler<RegistrationResonse>() {
            @Override
            public void onSuccessResponse(RegistrationResonse response) {
                getRegistrationResonseMutableLiveData().setValue(response);
            }

            @Override
            public void onErrorResponse(String errorMessage) {
                setError(errorMessage);

            }
        });
    }


}
