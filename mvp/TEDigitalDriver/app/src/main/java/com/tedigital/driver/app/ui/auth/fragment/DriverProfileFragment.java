package com.tedigital.driver.app.ui.auth.fragment;

import com.tedigital.driver.app.R;
import com.tedigital.driver.app.databinding.FragmenDriverProfileBinding;
import com.tedigital.driver.app.support.Constant;
import com.tedigital.driver.app.support.Constants;
import com.tedigital.driver.app.support.PrefManager;
import com.tedigital.driver.app.support.base.BaseFragment;
import com.tedigital.driver.app.ui.auth.viewmodel.DriverProfileViewModel;

public class DriverProfileFragment extends BaseFragment<FragmenDriverProfileBinding, DriverProfileViewModel> {

    FragmenDriverProfileBinding binding;
    DriverProfileViewModel viewModel;

    @Override
    protected Class<DriverProfileViewModel> setViewModel() {
        return DriverProfileViewModel.class;
    }

    @Override
    public int getLayout() {
        return R.layout.fragmen_driver_profile;
    }

    @Override
    public String getTitle() {
        return "Driver Profile";
    }

    @Override
    protected void getBinding(FragmenDriverProfileBinding binding) {

        this.binding = binding;
    }

    @Override
    protected void getViewModel(DriverProfileViewModel viewModel) {

        this.viewModel = viewModel;
    }


    @Override
    protected void init() {
        PrefManager prefManager = PrefManager.getInstance(requireContext());
        String driverName = prefManager.get(Constants.DUP_DRIVERNAME);
        String driverId = prefManager.get(Constants.DRIVER_ID);
        String memberId = prefManager.get(Constants.USER_ID);

        binding.txtDriverName.setText(driverName);
        binding.txtMemberId.setText("Member id  "+memberId);
        binding.txtWalletId.setText("Wallet id  "+driverId);

        binding.btnUpdateProfile.setOnClickListener(v -> showToast("Driver Profile update sucessfully", Constant.TOAST_SUCCESS));

    }
}
