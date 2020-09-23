package com.jobportalemployer.asizone.view.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jobportalemployer.asizone.R;
import com.jobportalemployer.asizone.presenter.utils.Constants;
import com.jobportalemployer.asizone.presenter.utils.CustomPerference;
import com.jobportalemployer.asizone.view.dashboard.DashboardActivity;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(CustomPerference.getBoolean(this, Constants.ISLOGIN))
        {
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        }
        setContentView(R.layout.activity_auth);

        findViewById(R.id.btnLogin).setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
        findViewById(R.id.btnRegister).setOnClickListener(v -> startActivity(new Intent(this, Registration.class)));
    }
}