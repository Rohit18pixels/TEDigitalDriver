package com.tedigital.driver.app.ui.auth;

import android.annotation.SuppressLint;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.tedigital.driver.app.R;
import com.tedigital.driver.app.databinding.ActivityAuthBinding;
import com.tedigital.driver.app.support.base.BaseActivity;
import com.tedigital.driver.app.support.base.BaseFragment;
import com.tedigital.driver.app.ui.auth.fragment.RegistrationFragment;

public class AuthActivity extends BaseActivity<ActivityAuthBinding, AuthActivityViewModel> implements BaseFragment.OnFragmentInteractionListener {

    ActivityAuthBinding binding;
    AuthActivityViewModel viewModel;


    @Override
    public int getLayout() {
        return R.layout.activity_auth;
    }

    @Override
    protected void getBinding(ActivityAuthBinding binding) {

        this.binding = binding;
    }

    @Override
    protected void getViewModel(AuthActivityViewModel viewModel) {

        this.viewModel = viewModel;
    }

    @Override
    protected Class<AuthActivityViewModel> setViewModel() {
        return AuthActivityViewModel.class;
    }

    @Override
    protected void init() {


//        setupNavigation();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onFragmentInteraction(String title) {
        binding.txtName.setText("Welcome in !");
    }

    public void setupNavigation()
    {
        loadFragment(new RegistrationFragment());
    }

    void loadFragment(Fragment fragment)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.commit();
    }
}