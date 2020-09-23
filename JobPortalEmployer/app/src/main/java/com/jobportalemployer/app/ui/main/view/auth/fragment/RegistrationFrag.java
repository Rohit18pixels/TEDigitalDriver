package com.jobportalemployer.app.ui.main.view.auth.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jobportalemployer.app.R;
import com.jobportalemployer.app.data.model.CityData;
import com.jobportalemployer.app.data.model.CountryResponce;
import com.jobportalemployer.app.data.model.StateData;
import com.jobportalemployer.app.databinding.RegistrationFragBinding;
import com.jobportalemployer.app.ui.main.adapter.CityListAdapter;
import com.jobportalemployer.app.ui.main.adapter.CountryListAdapter;
import com.jobportalemployer.app.ui.main.adapter.StateListAdapter;
import com.jobportalemployer.app.ui.main.viewmodel.RegistrationViewModel;
import com.jobportalemployer.app.utils.AlertDialogs;

import java.util.List;
import java.util.Objects;

public class RegistrationFrag extends Fragment implements CountryListAdapter.onClickInterface, StateListAdapter.onClickInterfaceState, CityListAdapter.onClickInterfaceCity {

    private ProgressBar indeterminateBar, progressCountry, proressState, progressCity;

    private RegistrationFragBinding binding;
    private RegistrationViewModel mvvm;

    private CountryListAdapter adapter;
    private StateListAdapter stateAdapter;
    private CityListAdapter cityAdapter;
    private AlertDialogs dialogs;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mvvm = new ViewModelProvider(requireActivity()).get(RegistrationViewModel.class);

        mvvm.getRegistrationObserv().observe(this, RegistrationResponse ->
                Toast.makeText(getActivity(), "Registration", Toast.LENGTH_LONG).show());

        mvvm.countryModelObserver().observe(this, CountryModel -> {

            List<CountryResponce> arrayList = CountryModel.getCountries();
            adapter = new CountryListAdapter(arrayList, this);

        });

        mvvm.stateModelObserver().observe(this, StateResponce ->
        {
            List<StateData> stateArrayList = StateResponce.getStates();
            stateAdapter = new StateListAdapter(stateArrayList, this);
        });

        mvvm.cityModelObserver().observe(this, CityResponce ->
        {
            List<CityData> cityArrayList = CityResponce.getCities();
            cityAdapter = new CityListAdapter(cityArrayList, this);
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.registration_frag, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        indeterminateBar = view.findViewById(R.id.indeterminateBar);
        progressCountry = view.findViewById(R.id.progressCountry);
        proressState = view.findViewById(R.id.proressState);
        progressCity = view.findViewById(R.id.progressCity);

        mvvm.executeCountryList();


        binding.btnNavigate.setOnClickListener(v ->
                {
                    indeterminateBar.setVisibility(View.VISIBLE);
                    binding.btnNavigate.setVisibility(View.GONE);
                    if (validate()) {
                        indeterminateBar.setVisibility(View.GONE);
                        binding.btnNavigate.setVisibility(View.VISIBLE);

                        Toast.makeText(getActivity(), "Success", Toast.LENGTH_LONG).show();
                    } else {
                        indeterminateBar.setVisibility(View.GONE);
                        binding.btnNavigate.setVisibility(View.VISIBLE);

                        Toast.makeText(getActivity(), "All fields are mandatory", Toast.LENGTH_LONG).show();
                    }
                }
        );

        binding.edtCountry.setOnClickListener(v -> {
            progressCountry.setVisibility(View.VISIBLE);
            dialogs = new AlertDialogs(Objects.requireNonNull(getActivity()), adapter);
            dialogs.show();

        });

        binding.edtState.setOnClickListener(v -> {
            proressState.setVisibility(View.VISIBLE);

            dialogs = new AlertDialogs(Objects.requireNonNull(getActivity()), stateAdapter);
            dialogs.show();

        });

        binding.edtCity.setOnClickListener(v -> {
            progressCity.setVisibility(View.VISIBLE);

            dialogs = new AlertDialogs(Objects.requireNonNull(getActivity()), cityAdapter);
            dialogs.show();

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
            mvvm.setRegistrationResponseMutableLiveData
                    (_emailId, _mobile, _password, _pinCode, _country, _state, _city, _companyName, _contactPerson);
            return true;
        }


    }

    @Override
    public void onClicked(int countryId, String countryName) {

        progressCountry.setVisibility(View.GONE);


        mvvm.executeStateList(countryId);

        binding.edtCountry.setText(countryName);
        dialogs.dismiss();

    }

    @Override
    public void onClickedState(int state_id, String state_name) {

        proressState.setVisibility(View.GONE);

        mvvm.executeCityList(state_id);

        binding.edtState.setText(state_name);
        dialogs.dismiss();
    }

    @Override
    public void onClickedCity(int cityId, String cityName) {

        progressCity.setVisibility(View.GONE);


        binding.edtCity.setText(cityName);
        dialogs.dismiss();

    }
}
