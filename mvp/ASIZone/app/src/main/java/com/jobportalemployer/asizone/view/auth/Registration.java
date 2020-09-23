package com.jobportalemployer.asizone.view.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.jobportalemployer.asizone.R;
import com.jobportalemployer.asizone.databinding.ActivityRegistrationBinding;
import com.jobportalemployer.asizone.model.auth.CityData;
import com.jobportalemployer.asizone.model.auth.CityResponce;
import com.jobportalemployer.asizone.model.auth.CountryModel;
import com.jobportalemployer.asizone.model.auth.CountryResponce;
import com.jobportalemployer.asizone.model.auth.RegistrationData;
import com.jobportalemployer.asizone.model.auth.RegistrationResponse;
import com.jobportalemployer.asizone.model.auth.StateData;
import com.jobportalemployer.asizone.model.auth.StateResponce;
import com.jobportalemployer.asizone.presenter.api.ApiResponseHandler;
import com.jobportalemployer.asizone.presenter.repository.Repository;
import com.jobportalemployer.asizone.presenter.utils.AppStuffs;
import com.jobportalemployer.asizone.presenter.utils.Constants;
import com.jobportalemployer.asizone.presenter.utils.CustomPerference;
import com.jobportalemployer.asizone.view.adapter.CityListAdapter;
import com.jobportalemployer.asizone.view.adapter.CountryListAdapter;
import com.jobportalemployer.asizone.view.adapter.StateListAdapter;

import java.util.List;
import java.util.Objects;

public class Registration extends AppCompatActivity implements CountryListAdapter.onClickInterface,
        StateListAdapter.onClickInterfaceState, CityListAdapter.onClickInterfaceCity {

    private List<CountryResponce> listResponce;
    private Repository repository;
    private Context context = Registration.this;


    private CountryListAdapter adapter;
    private StateListAdapter stateAdapter;
    private CityListAdapter cityAdapter;

    private ScrollView scrollView;
    ActivityRegistrationBinding binding;
    private int _countryId, _stateId, _cityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);


        scrollView = findViewById(R.id.scrollView);


        repository = new Repository();

        findViewById(R.id.btnNavigate).setOnClickListener(v -> {
            if (AppStuffs.isNetworkAvailable(this)) {
                binding.indeterminateBar.setVisibility(View.VISIBLE);
                validate();
            } else
                Snackbar.make(scrollView, "Check internet connectivity", BaseTransientBottomBar.LENGTH_LONG).isShown();
        });


        findViewById(R.id.edtCountry).setOnClickListener(v -> {
            binding.progressCountry.setVisibility(View.VISIBLE);
            repository.executeCountryList(new ApiResponseHandler<CountryModel>() {
                @Override
                public void onSuccessResponse(CountryModel response) {


                    listResponce = response.getCountries();
                    adapter = new CountryListAdapter(listResponce, Registration.this);
                    AppStuffs.CountryDialog(Registration.this, "Choose Country", adapter);

                }

                @Override
                public void onErrorResponse(String errorMessage) {

                }
            });
        });

    }

    public boolean validate() {


        String _emailId = Objects.requireNonNull(binding.edtEmailId.getText()).toString();
        String _mobile = Objects.requireNonNull(binding.edtMobile.getText()).toString();
        String _password = Objects.requireNonNull(binding.edtPassword.getText()).toString();
        String _pinCode = Objects.requireNonNull(binding.edtPinCode.getText()).toString();
        String _country = Objects.requireNonNull(binding.edtCountry.getText()).toString();
        String _state = Objects.requireNonNull(binding.edtState.getText()).toString();
        String _city = Objects.requireNonNull(binding.edtCity.getText()).toString();
        String _companyName = Objects.requireNonNull(binding.edtCompanyName.getText()).toString();
        String _contactPerson = Objects.requireNonNull(binding.edtContactPerson.getText()).toString();


        System.out.println("print" + _emailId + _mobile);
        if (TextUtils.isEmpty(_emailId)) {
            binding.edtEmailId.setError("Enter email");
            return false;
        } else if (TextUtils.isEmpty(_mobile)) {
            binding.edtMobile.setError("Enter mobile");
            return false;
        } else if (TextUtils.isEmpty(_password)) {
            binding.edtPassword.setError("Enter password");
            return false;
        } else if (TextUtils.isEmpty(_pinCode)) {
            binding.edtPinCode.setError("Enter pincode");
            return false;
        } else if (TextUtils.isEmpty(_country)) {
            binding.edtCountry.setError("Enter country");
            return false;
        } else if (TextUtils.isEmpty(_state)) {
            binding.edtState.setError("Enter state");
            return false;
        } else if (TextUtils.isEmpty(_city)) {
            binding.edtCity.setError("Enter city");
            return false;
        } else if (TextUtils.isEmpty(_companyName)) {
            binding.edtCompanyName.setError("Enter Company Name");
            return false;
        } else if (TextUtils.isEmpty(_contactPerson)) {
            binding.edtContactPerson.setError("Enter contact person name");
            return false;
        } else {


            repository.getRegistered(_emailId, _password, _pinCode, _countryId, _stateId, _cityId,
                    _companyName, _contactPerson, _mobile,
                    new ApiResponseHandler<RegistrationResponse>() {
                        @Override
                        public void onSuccessResponse(RegistrationResponse response) {

                            binding.indeterminateBar.setVisibility(View.GONE);
                            binding.btnNavigate.setVisibility(View.VISIBLE);
                            if (response.getCode().equalsIgnoreCase("200")) {

                                if (response.getStatus()) {
                                    List<RegistrationData> list = response.getData();

                                    RegistrationData data = list.get(0);

                                    System.out.println("eid"+data.getEid());
                                    Snackbar.make(scrollView, response.getMessage(), Snackbar.LENGTH_LONG).show();

                                    CustomPerference.putString(context, Constants.USER_EMAIL,_emailId);
                                    CustomPerference.putString(context, Constants.USER_PASSWORD, _password);
                                    CustomPerference.putString(context, Constants.PinCode, _pinCode );
                                    CustomPerference.putString(context, Constants.USER_MOBILE,_mobile);
                                    CustomPerference.putString(context, Constants.CompanyName,_companyName);
                                    CustomPerference.putString(context, Constants.USER_NAME,_contactPerson);

                                    startActivity(new Intent(Registration.this, OtpVerification.class)
                                            .putExtra("eid", data.getEid()));
//                                startActivity(new Intent(Registration.this, DashboardActivity.class));
                                    finish();
                                }
                                else
                                    AppStuffs.toast(scrollView, response.getMessage());
                            }
                            else
                                AppStuffs.toast(scrollView, response.getMessage());

                        }

                        @Override
                        public void onErrorResponse(String errorMessage) {
                            binding.indeterminateBar.setVisibility(View.GONE);
                            binding.btnNavigate.setVisibility(View.VISIBLE);
                        }
                    });
            return true;
        }
    }

    @Override
    public void onClicked(int countryId, String countryName) {

        binding.edtCountry.setText(countryName);
        binding.progressCountry.setVisibility(View.GONE);
        binding.proressState.setVisibility(View.VISIBLE);

        AppStuffs.dismissDialog();
        repository.executeStateList(countryId, new ApiResponseHandler<StateResponce>() {
            @Override
            public void onSuccessResponse(StateResponce response) {
                List<StateData> stateResponce = response.getStates();
                stateAdapter = new StateListAdapter(stateResponce, Registration.this::onClickedState);
                AppStuffs.CustomDialog(Registration.this, "Choose State", stateAdapter);

                _countryId = countryId;
            }

            @Override
            public void onErrorResponse(String errorMessage) {


            }
        });
    }

    @Override
    public void onClickedState(int stateId, String stateName) {

        binding.edtState.setText(stateName);

        binding.proressState.setVisibility(View.GONE);
        binding.progressCity.setVisibility(View.VISIBLE);

        AppStuffs.dismissDialog();
        repository.executeCityList(stateId, new ApiResponseHandler<CityResponce>() {
            @Override
            public void onSuccessResponse(CityResponce response) {
                List<CityData> cityResponce = response.getCities();
                cityAdapter = new CityListAdapter(cityResponce, Registration.this::onClickedCity);
                AppStuffs.CustomDialog(Registration.this, "Choose City", cityAdapter);
                _stateId = stateId;

            }

            @Override
            public void onErrorResponse(String errorMessage) {


            }
        });
    }

    @Override
    public void onClickedCity(int cityId, String cityName) {
        binding.progressCity.setVisibility(View.GONE);
        binding.edtCity.setText(cityName);
        AppStuffs.dismissDialog();
        _cityId = cityId;
    }
}