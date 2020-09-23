package com.jobportalemployer.app.ui.main.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jobportalemployer.app.data.api.ApiResponseHandler;
import com.jobportalemployer.app.data.model.CityResponce;
import com.jobportalemployer.app.data.model.CountryModel;
import com.jobportalemployer.app.data.model.RegistrationResponse;
import com.jobportalemployer.app.data.model.StateResponce;
import com.jobportalemployer.app.data.repository.Repository;

public class RegistrationViewModel extends AndroidViewModel {

    private Repository reistrationRepository, countryRepository;

    private final MutableLiveData<RegistrationResponse> registrationResponseMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<CountryModel> countryModelMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<StateResponce> stateResponceMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<CityResponce> cityResponceMutableLiveData = new MutableLiveData<>();

    public RegistrationViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    private void init()
    {
        reistrationRepository = new Repository();
        countryRepository = new Repository();
    }

    public MutableLiveData<RegistrationResponse> getRegistrationObserv()
    {
        return registrationResponseMutableLiveData;
    }
    public MutableLiveData<CountryModel> countryModelObserver()
    {
        return countryModelMutableLiveData;
    }

    public MutableLiveData<StateResponce> stateModelObserver()
    {
        return stateResponceMutableLiveData;
    }
    public MutableLiveData<CityResponce> cityModelObserver()
    {
        return cityResponceMutableLiveData;
    }

    public void setRegistrationResponseMutableLiveData(String email, String password, String pinCode, String Country, String state,
                                                       String city,
                                                       String company, String contactPerson, String mobile)
    {
        reistrationRepository.getRegistered(email, password, pinCode, Country, state, city, company, contactPerson, mobile
                , new ApiResponseHandler<RegistrationResponse>() {
                    @Override
                    public void onSuccessResponse(RegistrationResponse response) {
                        registrationResponseMutableLiveData.postValue(response);
                    }

                    @Override
                    public void onErrorResponse(String errorMessage) {

                        registrationResponseMutableLiveData.postValue(null);
                    }
                });
    }


    public void executeCountryList()
    {
        countryRepository.executeCountryList(new ApiResponseHandler<CountryModel>() {
            @Override
            public void onSuccessResponse(CountryModel response) {
                countryModelMutableLiveData.postValue(response);
            }

            @Override
            public void onErrorResponse(String errorMessage) {
                countryModelMutableLiveData.postValue(null);
            }
        });
    }

    public void executeStateList(int countryId)
    {
        countryRepository.executeStateList(countryId, new ApiResponseHandler<StateResponce>() {
            @Override
            public void onSuccessResponse(StateResponce response) {
                stateResponceMutableLiveData.postValue(response);
            }

            @Override
            public void onErrorResponse(String errorMessage) {
                stateResponceMutableLiveData.postValue(null);
            }
        });
    }

    public void executeCityList(int stateId)
    {
        countryRepository.executeCityList(stateId, new ApiResponseHandler<CityResponce>() {
            @Override
            public void onSuccessResponse(CityResponce response) {
                cityResponceMutableLiveData.postValue(response);
                if(response.getCities().isEmpty())
                {
                    System.out.println("Nores0"+"onoonononono");
                }
            }

            @Override
            public void onErrorResponse(String errorMessage) {
                cityResponceMutableLiveData.postValue(null);
            }
        });
    }
}
