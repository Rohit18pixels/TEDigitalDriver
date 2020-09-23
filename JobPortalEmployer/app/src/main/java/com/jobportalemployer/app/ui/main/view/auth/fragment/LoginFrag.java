package com.jobportalemployer.app.ui.main.view.auth.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jobportalemployer.app.R;
import com.jobportalemployer.app.databinding.LoginFragmentBinding;
import com.jobportalemployer.app.ui.main.viewmodel.LoginViewModel;

import java.util.Objects;

public class LoginFrag extends Fragment {

    private LoginFragmentBinding binding;
    private LoginViewModel mvvm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mvvm = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        mvvm.getLoginObserber().observe(this, loginResponce -> {

        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnNavigate.setOnClickListener(v -> {

                    if (!TextUtils.isEmpty(Objects.requireNonNull(binding.edtPassword.getText()).toString()) &&
                            !TextUtils.isEmpty(binding.edtMobileNumber.getText()))
                    {

                        mvvm.login(Objects.requireNonNull(binding.edtMobileNumber.getText()).toString(),
                                binding.edtPassword.getText().toString());

                    }
                }
        );
    }
}
