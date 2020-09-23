package com.jobportalemployer.app.data.repository;

import com.jobportalemployer.app.data.api.ApiResponseHandler;
import com.jobportalemployer.app.data.api.ApiService;
import com.jobportalemployer.app.data.api.ApiServiceImpl;
import com.jobportalemployer.app.data.model.CityResponce;
import com.jobportalemployer.app.data.model.CountryModel;
import com.jobportalemployer.app.data.model.LoginResponce;
import com.jobportalemployer.app.data.model.RegistrationResponse;
import com.jobportalemployer.app.data.model.StateResponce;

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
    
    public void getRegistered(String email, String password, String pinCode, String Country, String state, String city,
                              String company, String contactPerson, String mobile,
                              ApiResponseHandler<RegistrationResponse> apiResponseHandler)
    {
        Call<RegistrationResponse> executeRegistration = myInterface.getComReg(email, password, pinCode, Country, state, city, company,
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
        Call<CityResponce> bindState = myInterface.executeCity(2);

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

}
