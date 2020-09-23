package com.jobportalemployer.asizone.view.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.jobportalemployer.asizone.R;
import com.jobportalemployer.asizone.databinding.ActivityLoginBinding;
import com.jobportalemployer.asizone.model.auth.LoginResponce;
import com.jobportalemployer.asizone.presenter.api.ApiResponseHandler;
import com.jobportalemployer.asizone.presenter.repository.Repository;
import com.jobportalemployer.asizone.presenter.utils.AppStuffs;
import com.jobportalemployer.asizone.presenter.utils.Constants;
import com.jobportalemployer.asizone.presenter.utils.CustomPerference;
import com.jobportalemployer.asizone.view.dashboard.DashboardActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Repository repository;
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        repository = new Repository();


        findViewById(R.id.btnNavigate).setOnClickListener(v -> {
            if(AppStuffs.isNetworkAvailable(this)){
                AppStuffs.closeKeyboard(LoginActivity.this);
                validate();

            }
            else
                Snackbar.make(binding.rlLayout, "Internet connectivity lost", Snackbar.LENGTH_LONG).show();

        });

    }

    public void validate() {

        binding.btnNavigate.setVisibility(View.GONE);
        binding.indeterminateBar.setVisibility(View.VISIBLE);
        String _emailId = Objects.requireNonNull(edtEmail.getText()).toString();
        String _password = Objects.requireNonNull(edtPassword.getText()).toString();


        if (TextUtils.isEmpty(_emailId)) {
            edtEmail.setError("Enter email");

        }
        else if (TextUtils.isEmpty(_password)) {
            edtPassword.setError("Enter password");
        }
        else {

            repository.getLogingBody(_emailId,  _password, new ApiResponseHandler<LoginResponce>() {
                        @Override
                        public void onSuccessResponse(LoginResponce response) {
                            binding.indeterminateBar.setVisibility(View.GONE);
                            binding.btnNavigate.setVisibility(View.VISIBLE);
                            if(response.getCode().equalsIgnoreCase("200"))
                            {
                                if(response.getStatus()) {

                                    CustomPerference.putBoolean(LoginActivity.this, Constants.ISLOGIN, true);
                                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                                    finish();
                                }
                                else
                                    AppStuffs.toast(binding.rlLayout, response.getMessage());
                                CustomPerference.putBoolean(LoginActivity.this, Constants.ISLOGIN, true);
                                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                                finish();
                            }
                            else
                                AppStuffs.toast(binding.rlLayout, response.getMessage());
                        }

                        @Override
                        public void onErrorResponse(String errorMessage) {
                            binding.indeterminateBar.setVisibility(View.GONE);
                            binding.btnNavigate.setVisibility(View.VISIBLE);

                        }
                    });
        }


    }
}