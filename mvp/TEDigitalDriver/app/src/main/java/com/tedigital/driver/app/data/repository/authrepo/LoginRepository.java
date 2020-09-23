package com.tedigital.driver.app.data.repository.authrepo;

import com.google.gson.JsonObject;
import com.tedigital.driver.app.data.api.ApiResponseHandler;
import com.tedigital.driver.app.data.api.ApiService;
import com.tedigital.driver.app.data.api.ApiServiceImpl;
import com.tedigital.driver.app.data.model.authmodel.SendOtpResponse;
import com.tedigital.driver.app.data.model.authmodel.VerifyOtpResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    private static ApiService myInterface;

    public LoginRepository() {
        myInterface = ApiServiceImpl.getClient();
    }

    public void getOtpResponse(JsonObject jsonObject, ApiResponseHandler<SendOtpResponse> apiResponseHandler) {
        Call<SendOtpResponse> callMethod = myInterface.sendOTP(jsonObject);
        callMethod.enqueue(new Callback<SendOtpResponse>() {
            @Override
            public void onResponse(@NotNull Call<SendOtpResponse> call, @NotNull Response<SendOtpResponse> response) {

                if (response.code() == 400)
                    apiResponseHandler.onErrorResponse("User Not Found in the system or Server Error");
                else if (response.isSuccessful())
                    apiResponseHandler.onSuccessResponse(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<SendOtpResponse> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());
            }
        });
    }

    public void getVerifyOTP(String authorization, String otp, String mobile, ApiResponseHandler<VerifyOtpResponse> apiResponseHandler) {
        Call<VerifyOtpResponse> verifyOtpResponseCall = myInterface.verifyOTP(authorization, otp, mobile);
        verifyOtpResponseCall.enqueue(new Callback<VerifyOtpResponse>() {
            @Override
            public void onResponse(@NotNull Call<VerifyOtpResponse> call, @NotNull Response<VerifyOtpResponse> response) {

                if (response.code() == 401)
                    apiResponseHandler.onErrorResponse("Wrong OTP");
                else if (response.isSuccessful())
                    apiResponseHandler.onSuccessResponse(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<VerifyOtpResponse> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());
            }
        });
    }


}
