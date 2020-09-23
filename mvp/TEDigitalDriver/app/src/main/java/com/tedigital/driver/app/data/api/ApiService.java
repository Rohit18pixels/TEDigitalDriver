package com.tedigital.driver.app.data.api;


import com.google.gson.JsonObject;
import com.tedigital.driver.app.data.model.authmodel.RegistrationResonse;
import com.tedigital.driver.app.data.model.authmodel.SendOtpResponse;
import com.tedigital.driver.app.data.model.authmodel.UploadFileResponse;
import com.tedigital.driver.app.data.model.authmodel.VerifyOtpResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface ApiService {

    @POST("auth/sendOTPDriver")
    Call<SendOtpResponse> sendOTP(@Body JsonObject sendOTPBody);

    @FormUrlEncoded
    @POST("auth/verifyOTPDriver")
    Call<VerifyOtpResponse> verifyOTP(@Header("Authorization") String header,
                                      @Field(value = "OTP") String otp,
                                      @Field(value = "Username") String userName);


    @PUT
    Call<RegistrationResonse> register(@Url String url, @Body JsonObject registerBody);

    @Multipart
    @POST("attachment/upload/uploadSingleFile")
    Call<UploadFileResponse> uploadFile(
            @Part MultipartBody.Part paths );


//            @Part MultipartBody.Part file);
}
