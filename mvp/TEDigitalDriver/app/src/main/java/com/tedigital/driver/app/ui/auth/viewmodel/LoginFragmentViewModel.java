package com.tedigital.driver.app.ui.auth.viewmodel;

import android.util.Base64;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.tedigital.driver.app.data.api.ApiResponseHandler;
import com.tedigital.driver.app.data.model.authmodel.SendOtpResponse;
import com.tedigital.driver.app.data.model.authmodel.VerifyOtpResponse;
import com.tedigital.driver.app.data.repository.authrepo.LoginRepository;
import com.tedigital.driver.app.support.base.BaseViewModel;

public class LoginFragmentViewModel extends BaseViewModel {

    private final MutableLiveData<SendOtpResponse> sendOtpMutableLiveData;
    LoginRepository loginRepository;
    private final MutableLiveData<VerifyOtpResponse> verifyOtpMutableLiveData;

    public LoginFragmentViewModel() {

        loginRepository = new LoginRepository();

        sendOtpMutableLiveData = new MutableLiveData<>();
        verifyOtpMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<SendOtpResponse> getSendOtpMutableLiveData() {
        return sendOtpMutableLiveData;
    }

    public MutableLiveData<VerifyOtpResponse> getVerifyOtpMutableLiveData() {
        return verifyOtpMutableLiveData;
    }

    public void sendOTP(JsonObject jsonObject) {
        loginRepository.getOtpResponse(jsonObject, new ApiResponseHandler<SendOtpResponse>() {

            @Override
            public void onSuccessResponse(SendOtpResponse response) {
                sendOtpMutableLiveData.setValue(response);

            }

            @Override
            public void onErrorResponse(String errorMessage) {
                setError(errorMessage);


            }
        });
    }

    public void verifyOTP(String mobileNumber, String otp)
    {
        loginRepository.getVerifyOTP(convertIntoB64(mobileNumber, otp), otp, mobileNumber, new ApiResponseHandler<VerifyOtpResponse>() {
            @Override
            public void onSuccessResponse(VerifyOtpResponse response) {
                verifyOtpMutableLiveData.setValue(response);
            }

            @Override
            public void onErrorResponse(String errorMessage) {
               setError(errorMessage);
            }
        });
    }

    public String convertIntoB64(String mobileEmailStr, String otp) {

        String encoOtp = ":" + otp;
        String encode = mobileEmailStr + encoOtp;

        byte[] encodeToken = encode.getBytes();

        return "Basic " + Base64.encodeToString(encodeToken, Base64.NO_WRAP);

    }
}
