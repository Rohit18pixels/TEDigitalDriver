package com.jobportalemployer.asizone.view.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.jobportalemployer.asizone.R;
import com.jobportalemployer.asizone.databinding.ActivityOtpVerificationBinding;
import com.jobportalemployer.asizone.model.auth.OTPDataum;
import com.jobportalemployer.asizone.model.auth.OTPResponce;
import com.jobportalemployer.asizone.presenter.api.ApiResponseHandler;
import com.jobportalemployer.asizone.presenter.repository.Repository;
import com.jobportalemployer.asizone.presenter.utils.AppStuffs;
import com.jobportalemployer.asizone.presenter.utils.Constants;
import com.jobportalemployer.asizone.presenter.utils.CustomPerference;
import com.jobportalemployer.asizone.view.dashboard.DashboardActivity;

import java.util.List;

public class OtpVerification extends AppCompatActivity {

    ActivityOtpVerificationBinding binding;

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otp_verification);

        String eid = getIntent().getStringExtra("eid");
        repository = new Repository();

        binding.btnNavigate.setOnClickListener(v -> {
            AppStuffs.closeKeyboard(OtpVerification.this);
            String txtOtp = binding.edtOTP.getText().toString();
            if (TextUtils.isEmpty(txtOtp))
                binding.edtOTP.setError("OTP field are mandatory");
            else {
                if (AppStuffs.isNetworkAvailable(this)){
                    binding.indeterminateBar.setVisibility(View.VISIBLE);
                    binding.btnNavigate.setVisibility(View.GONE);
                    executeVerifyOtp(Integer.parseInt(txtOtp), Integer.parseInt(eid));}
                else AppStuffs.toast(binding.viewLinear, "No internet");
            }
        });
    }

    public void executeVerifyOtp(int txtOtp, int eid) {
        repository.executeOTPVerification(txtOtp, eid, new ApiResponseHandler<OTPResponce>() {
            @Override
            public void onSuccessResponse(OTPResponce response) {
                binding.indeterminateBar.setVisibility(View.GONE);
                binding.btnNavigate.setVisibility(View.VISIBLE);
                AppStuffs.toast(binding.viewLinear,response.getMessage());
                if(response.getStatus())
                {
                    List<OTPDataum> list = response.getData();
                    CustomPerference.putString(OtpVerification.this, Constants.EID, list.get(0).getEid());
                    startActivity(new Intent(OtpVerification.this, DashboardActivity.class).
                            setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            }

            @Override
            public void onErrorResponse(String errorMessage) {
                binding.indeterminateBar.setVisibility(View.GONE);
                binding.btnNavigate.setVisibility(View.VISIBLE);
            }
        });

    }
}