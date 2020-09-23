package com.jobportalemployer.app.ui.main.view.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.jobportalemployer.app.R;
import com.jobportalemployer.app.ui.main.adapter.TabAdapter;
import com.jobportalemployer.app.ui.main.view.auth.fragment.LoginFrag;
import com.jobportalemployer.app.ui.main.view.auth.fragment.RegistrationFrag;

public class AuthActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFrag(), "Login");
        adapter.addFragment(new RegistrationFrag(), "Registration");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}