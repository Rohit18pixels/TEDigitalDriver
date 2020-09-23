package com.tedigital.driver.app.ui.auth.fragment;

import android.os.CountDownTimer;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tedigital.driver.app.R;
import com.tedigital.driver.app.databinding.FragmentLoginBinding;
import com.tedigital.driver.app.support.Constant;
import com.tedigital.driver.app.support.Constants;
import com.tedigital.driver.app.support.PrefManager;
import com.tedigital.driver.app.support.base.BaseFragment;
import com.tedigital.driver.app.ui.auth.viewmodel.LoginFragmentViewModel;

import java.util.Objects;

import static com.tedigital.driver.app.ui.auth.fragment.RegistrationFragment.jsonArray;

public class LoginFragment extends BaseFragment<FragmentLoginBinding, LoginFragmentViewModel> {

    FragmentLoginBinding binding;
    LoginFragmentViewModel viewModel;
    BottomSheetBehavior bottomSheetBehavior;
    private String mobileNumber;
    private PrefManager prefManager;
    NavController navController;

    @Override
    protected Class<LoginFragmentViewModel> setViewModel() {
        return LoginFragmentViewModel.class;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public String getTitle() {
        return "Login Form";
    }

    @Override
    protected void getBinding(FragmentLoginBinding binding) {
        this.binding = binding;

    }

    @Override
    protected void getViewModel(LoginFragmentViewModel viewModel) {
        this.viewModel = viewModel;
    }


    @Override
    protected void init() {

        prefManager = PrefManager.getInstance(getContext());
        bottomSheetBehaviorObserve();
        navController = Navigation.findNavController(requireView());

        binding.btnRegistration.setOnClickListener(v -> loadFragment(new RegistrationFragment()));

        binding.btnGetOtp.setOnClickListener(v -> executeSendOTP());
        binding.bottomSheetOtpVerification.txtResend.setOnClickListener(v -> {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            binding.bottomSheetOtpVerification.txtResend.setVisibility(View.GONE);
            binding.bottomSheetOtpVerification.etOtp.setText("");

            executeSendOTP();
        });
        binding.bottomSheetOtpVerification.btnVerifyOtp.setOnClickListener(v -> executeVerifyOTP());

        binding.bottomSheetOtpVerification.imgClose.setOnClickListener(v ->
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED));
    }


    void bottomSheetBehaviorObserve() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetOtpVerification.bottomSheetLl);
        // set callback for changes
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                binding.blur.setVisibility(View.VISIBLE);
                binding.blur.setAlpha(slideOffset);
            }
        });
    }

    public void executeSendOTP() {

        binding.btnGetOtp.setVisibility(View.GONE);
        binding.progressBar.setVisibility(View.VISIBLE);

        mobileNumber = Objects.requireNonNull(binding.inputMobileNumber.getText()).toString();

        if (inputValidate(mobileNumber) && mobileNumber.length() >= 10) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("userId", mobileNumber);

            viewModel.sendOTP(jsonObject);

            viewModel.getError().observe(requireActivity(), s -> {
                showToast(s, Constant.TOAST_ERROR);
                binding.btnGetOtp.setVisibility(View.VISIBLE);
                binding.progressBar.setVisibility(View.GONE);
            });

            viewModel.getSendOtpMutableLiveData().observe(requireActivity(), sendOtpResponse -> {

                if (sendOtpResponse.getUserId() != null)
                    showToast("OTP Send", Constant.TOAST_SUCCESS);
                binding.bottomSheetOtpVerification.txtMobile.setText(mobileNumber);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                countDownTimer();
                binding.btnGetOtp.setVisibility(View.VISIBLE);
                binding.progressBar.setVisibility(View.GONE);

            });
        } else {
            binding.btnGetOtp.setVisibility(View.VISIBLE);
            binding.progressBar.setVisibility(View.GONE);

            binding.inputMobileNumber.setError("Check Mobile Number");
        }
    }

    public void loadFragment(Fragment fragment) {
        FragmentManager manager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.commit();
    }

    void executeVerifyOTP() {

        String otp = Objects.requireNonNull(binding.bottomSheetOtpVerification.etOtp.getText()).toString();
        if (inputValidate(otp))
            viewModel.verifyOTP(mobileNumber, otp);
        else
            showToast("Enter OTP", Constant.TOAST_ERROR);

        viewModel.getError().observe(requireActivity(), s ->
                showToast(s, Constant.TOAST_ERROR));

        viewModel.getVerifyOtpMutableLiveData().observe(requireActivity(), verifyOtpResponse -> {
            showToast("OTP Verified", Constant.TOAST_SUCCESS);
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            binding.bottomSheetOtpVerification.etOtp.setText("");

            prefManager.put(Constants.DRIVER_ID, verifyOtpResponse.getId());
            prefManager.put(Constants.DUP_DRIVERNAME, verifyOtpResponse.getDriverName());
            prefManager.put(Constants.DUP_DOB, verifyOtpResponse.getDob());
            prefManager.put(Constants.DUP_DRIVINGLICENSEVALIDITY, verifyOtpResponse.getLicenseValidity());
            prefManager.put(Constants.DUP_DRIVINGLICENSE, verifyOtpResponse.getDlNumber());
            prefManager.put(Constants.DUP_INSURANCEPOLICYVALIDTY, (String) verifyOtpResponse.getInsuranceValidityDate());
            prefManager.put(Constants.DUP_INSURANCEPOLICY, (String) verifyOtpResponse.getPolicyInsuranceNumber());
            prefManager.put(Constants.DUP_DRIVEREXPERIENCE, verifyOtpResponse.getYearOfExp());
            prefManager.put(Constants.DUP_ADDRESS, (String) verifyOtpResponse.getAddress());
            prefManager.put(Constants.DUP_SPECIALLICENSE, verifyOtpResponse.getSpecialLicense());
            prefManager.put(Constants.DUP_VEHICLELICENSETYPE, verifyOtpResponse.getLicenseCategory());
            prefManager.put(Constants.DUP_PHONETYPE, verifyOtpResponse.getPhoneType().getValue());
            prefManager.put(Constants.DUP_MOBILENUMBER, String.valueOf(verifyOtpResponse.getMobileNumber()));
            prefManager.put(Constants.DUP_BLOODGROUP, String.valueOf(verifyOtpResponse.getBloodGroup()));

            prefManager.put(Constants.DUP_LANGUAGES_KNOWN, verifyOtpResponse.getLanguages().get(0));
            prefManager.put(Constants.DUP_MARITIAL_STATUS, verifyOtpResponse.getMaritalStatus());
//                prefManager.put(Constants.DUP_LAN_ENGLISH,  verifyOtpResponse.getLanguages().get(1));

            prefManager.put(Constants.DKYC_RC, (String) verifyOtpResponse.getTruckRCFrontPhotoKey());
            prefManager.put(Constants.DKYC_RC, (String) verifyOtpResponse.getTruckRCFrontPhotoKey());

            prefManager.put(Constants.DKYC_PANNUMBER, verifyOtpResponse.getPanNumber());
            prefManager.put(Constants.DKYC_AADHARNUMBER, verifyOtpResponse.getAadharNumber());
            prefManager.put(Constants.DKYC_LICENSENUMBER, verifyOtpResponse.getLicenseNumber());
            prefManager.put(Constants.DKYC_TRUCKNUMBER, verifyOtpResponse.getTruckNumber());
            prefManager.put(Constants.DKYC_RCNUMBER, verifyOtpResponse.getTruckRCNumber());

            prefManager.put(Constants.DKYC_PAN, (String) verifyOtpResponse.getPanNumberKey());
            prefManager.put(Constants.DKYC_AADHARFRONT, (String) verifyOtpResponse.getAadharCardKey());
            prefManager.put(Constants.DKYC_AADHATBACK, (String) verifyOtpResponse.getAadharCardKey());
            prefManager.put(Constants.DKYC_LICENSEFRONT, (String) verifyOtpResponse.getLicenseKey());
            prefManager.put(Constants.DKYC_LICENSEBACK, (String) verifyOtpResponse.getLicenseKey());

            prefManager.put(Constants.DKYC_TRUCKFRONT, (String) verifyOtpResponse.getTruckFrontPhotoKey());
            prefManager.put(Constants.DKYC_TRUCKSIDE, (String) verifyOtpResponse.getTruckSidePhotoKey());
            prefManager.put(Constants.DKYC_TRUCKBACK, (String) verifyOtpResponse.getTruckBackPhotoKey());
            prefManager.put(Constants.DKYC_RC, (String) verifyOtpResponse.getTruckRCFrontPhotoKey());

            prefManager.put(Constants.DKYC_SELFIETRUCK, verifyOtpResponse.getSelfieWithTruckKey());
            prefManager.put(Constants.DUP_SPECIALLICENSE_KEY, verifyOtpResponse.getSpecialLicencekey());
            prefManager.put(Constants.DKYC_DRIVER_PROFILE_IMAGE, verifyOtpResponse.getDriverProfileImageKey());

            for (String array : verifyOtpResponse.getLanguages())
                jsonArray.add(array);


//            prefManager.put(Constants.DUP_SPECIALLICENSE_KEY,  verifyOtpResponse.getTruckRCFrontPhotoKey());


            navController.navigate(R.id.action_loginFragment_to_registrationFragment);


        });
    }

    void countDownTimer() {
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                binding.bottomSheetOtpVerification.txtTimer.setText("wait for: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
//                binding.bottomSheetOtpVerification.txtTimer.setText("done!");
                binding.bottomSheetOtpVerification.txtResend.setVisibility(View.VISIBLE);
            }
        }.start();
    }

}
