package com.tedigital.driver.app.data.repository.authrepo;

import com.google.gson.JsonObject;
import com.tedigital.driver.app.data.api.ApiResponseHandler;
import com.tedigital.driver.app.data.api.ApiService;
import com.tedigital.driver.app.data.api.ApiServiceImpl;
import com.tedigital.driver.app.data.model.authmodel.RegistrationResonse;
import com.tedigital.driver.app.data.model.authmodel.UploadFileResponse;

import org.jetbrains.annotations.NotNull;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadDocsRepository {

    private static ApiService myInterface;

    public UploadDocsRepository() {
        myInterface = ApiServiceImpl.getClient();
    }

    public void uploadImageFile(MultipartBody.Part requestFile, ApiResponseHandler<UploadFileResponse> apiResponseHandler)
    {
        Call<UploadFileResponse> call = myInterface.uploadFile(requestFile);
        call.enqueue(new Callback<UploadFileResponse>() {
            @Override
            public void onResponse(@NotNull Call<UploadFileResponse> call, @NotNull Response<UploadFileResponse> response) {
                apiResponseHandler.onSuccessResponse(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<UploadFileResponse> call, @NotNull Throwable t) {

                apiResponseHandler.onErrorResponse(t.getMessage());
            }
        });
    }


    public void getUpdateProfile(String driverId, JsonObject jsonObject, ApiResponseHandler<RegistrationResonse> apiResponseHandler)
    {
        Call<RegistrationResonse> callMethod = myInterface.register("/auth/profile/"+driverId+"/updateDriver",jsonObject);
        callMethod.enqueue(new Callback<RegistrationResonse>() {
            @Override
            public void onResponse(@NotNull Call<RegistrationResonse> call, @NotNull Response<RegistrationResonse> response) {

                apiResponseHandler.onSuccessResponse(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<RegistrationResonse> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());
            }
        });
    }
}
