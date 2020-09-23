package com.machinetest.app.ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.google.android.material.snackbar.Snackbar;
import com.machinetest.app.R;
import com.machinetest.app.databinding.ActivityLoginBinding;
import com.machinetest.app.support.AppStuffs;
import com.machinetest.app.support.Constants;
import com.machinetest.app.support.CustomPerference;
import com.machinetest.app.support.base.BaseMvvmActivity;
import com.machinetest.app.ui.registration.Registration;
import com.machinetest.app.ui.user_list.MainActivity;

import java.util.Objects;

public class LoginActivity extends BaseMvvmActivity<LoginViewModel> {


    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(CustomPerference.getBoolean(this, Constants.ISLOGIN))
        {
            carls_startActivity(MainActivity.class);
            finish();
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.txtSignUp.setOnClickListener(v ->    carls_startActivity(Registration.class));

        binding.btnNavigate.setOnClickListener(v -> {
            //Internet connectivity is put just for demo not interlink with local access
            if (AppStuffs.isNetworkAvailable(this)) {
                AppStuffs.closeKeyboard(LoginActivity.this);
                validate();

            } else
                Snackbar.make(binding.rlLayout, "Internet connectivity lost", Snackbar.LENGTH_LONG).show();

        });


    }

    @Override
    protected void carls_bindViews() {




    }

    @Override
    protected Class<LoginViewModel> createViewModelClass() {
        return LoginViewModel.class;
    }

    public void validate() {

        binding.btnNavigate.setVisibility(View.GONE);
        binding.indeterminateBar.setVisibility(View.VISIBLE);

        String _userName = Objects.requireNonNull(binding.edtUserName.getText()).toString();
        String _password = Objects.requireNonNull(binding.edtPassword.getText()).toString();


        if (TextUtils.isEmpty(_userName) && TextUtils.isEmpty(_password)) {
            binding.btnNavigate.setVisibility(View.VISIBLE);
            binding.indeterminateBar.setVisibility(View.GONE);

        } else {
            binding.btnNavigate.setVisibility(View.VISIBLE);
            binding.indeterminateBar.setVisibility(View.GONE);

            if (!mvvm.login(_userName, _password))
                AppStuffs.toast(binding.rlLayout, "Login failed");

            else{
                CustomPerference.putString(LoginActivity.this, Constants.USERName, _userName);
                CustomPerference.putBoolean(LoginActivity.this, Constants.ISLOGIN, true);
                carls_startActivity(MainActivity.class);}
        }

    }
}