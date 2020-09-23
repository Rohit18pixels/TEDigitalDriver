package com.machinetest.app.ui.main.view.auth;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.machinetest.app.ui.user_list.MainActivity;
import com.machinetest.app.R;
import com.machinetest.app.databinding.ActivityAuthBinding;
import com.machinetest.app.support.Constants;
import com.machinetest.app.support.CustomPerference;
import com.machinetest.app.ui.login.LoginActivity;
import com.machinetest.app.ui.registration.Registration;


public class AuthActivity extends AppCompatActivity {

    ActivityAuthBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(CustomPerference.getBoolean(this, Constants.ISLOGIN))
        {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth);

        binding.btnLogin.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
        binding.btnRegister.setOnClickListener(v -> startActivity(new Intent(this, Registration.class)));
    }
}