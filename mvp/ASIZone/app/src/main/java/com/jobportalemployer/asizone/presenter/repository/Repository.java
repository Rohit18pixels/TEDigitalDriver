package com.jobportalemployer.asizone.presenter.repository;


import com.jobportalemployer.asizone.model.auth.CityResponce;
import com.jobportalemployer.asizone.model.auth.CountryModel;
import com.jobportalemployer.asizone.model.auth.LoginResponce;
import com.jobportalemployer.asizone.model.auth.OTPResponce;
import com.jobportalemployer.asizone.model.auth.RegistrationResponse;
import com.jobportalemployer.asizone.model.auth.StateResponce;
import com.jobportalemployer.asizone.presenter.api.ApiResponseHandler;
import com.jobportalemployer.asizone.presenter.api.ApiService;
import com.jobportalemployer.asizone.presenter.api.ApiServiceImpl;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private static ApiService myInterface ;

    public Repository() {
        myInterface =  ApiServiceImpl.getClient();
    }


    public void getLogingBody(String username, String password, ApiResponseHandler<LoginResponce> apiResponseHandler) {
        Call<LoginResponce> getLogin = myInterface.getEmpLogin(username, password);
        getLogin.enqueue(new Callback<LoginResponce>() {
            @Override
            public void onResponse(@NotNull Call<LoginResponce> call, @NotNull Response<LoginResponce> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }
//(t == null)? "" : t.getMessage()
            @Override
            public void onFailure(@NotNull Call<LoginResponce> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());

            }
        });
    }
    
    public void getRegistered(String email, String password, String pinCode, int Country, int state, int city,
                              String company, String contactPerson, String mobile,
                              ApiResponseHandler<RegistrationResponse> apiResponseHandler)
    {
        Call<RegistrationResponse> executeRegistration = myInterface.getComReg(email, password,
                pinCode, Country, state, city, company,
                contactPerson, mobile);

        executeRegistration.enqueue(new Callback<RegistrationResponse>() {

            @Override
            public void onResponse(@NotNull Call<RegistrationResponse> call, @NotNull Response<RegistrationResponse> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }
//(t == null)? "" : t.getMessage()
            @Override
            public void onFailure(@NotNull Call<RegistrationResponse> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());

            }
        });
    }


    public void executeCountryList( ApiResponseHandler<CountryModel> apiResponseHandler)
    {
        Call<CountryModel> executeCountry = myInterface.executeCountry();

        executeCountry.enqueue(new Callback<CountryModel>() {

            @Override
            public void onResponse(@NotNull Call<CountryModel> call, @NotNull Response<CountryModel> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<CountryModel> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());

            }
        });
    }


    public void executeStateList(int country_id, ApiResponseHandler<StateResponce> apiResponseHandler)
    {
        Call<StateResponce> bindState = myInterface.executeState(country_id);

        bindState.enqueue(new Callback<StateResponce>() {

            @Override
            public void onResponse(@NotNull Call<StateResponce> call, @NotNull Response<StateResponce> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<StateResponce> call, @NotNull Throwable t) {

            }

        });
    }

    public void executeCityList(int state_id, ApiResponseHandler<CityResponce> apiResponseHandler)
    {
        Call<CityResponce> bindState = myInterface.executeCity(state_id);

        bindState.enqueue(new Callback<CityResponce>() {

            @Override
            public void onResponse(@NotNull Call<CityResponce> call, @NotNull Response<CityResponce> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<CityResponce> call, @NotNull Throwable t) {

            }

        });
    }

    public void executeOTPVerification(int otp, int eid, ApiResponseHandler<OTPResponce> apiResponseHandler)
    {
        Call<OTPResponce> otpverification = myInterface.executeotpverify(otp, eid);
        otpverification.enqueue(new Callback<OTPResponce>() {
            @Override
            public void onResponse(Call<OTPResponce> call, Response<OTPResponce> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }

            @Override
            public void onFailure(Call<OTPResponce> call, Throwable t) {

            }
        });
    }

}
