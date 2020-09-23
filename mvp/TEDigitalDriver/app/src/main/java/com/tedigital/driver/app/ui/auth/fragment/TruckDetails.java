package com.tedigital.driver.app.ui.auth.fragment;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.tedigital.driver.app.R;
import com.tedigital.driver.app.databinding.FragmentTruckDetailsBinding;
import com.tedigital.driver.app.support.Constants;
import com.tedigital.driver.app.support.base.BaseFragment;
import com.tedigital.driver.app.ui.auth.viewmodel.TruckDetailsViewModel;

public class TruckDetails extends BaseFragment<FragmentTruckDetailsBinding, TruckDetailsViewModel> {

    FragmentTruckDetailsBinding binding;
    TruckDetailsViewModel viewModel;
    NavController navController;

    @Override
    protected Class<TruckDetailsViewModel> setViewModel() {
        return TruckDetailsViewModel.class;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_truck_details;
    }

    @Override
    public String getTitle() {
        return "Truck Details";
    }

    @Override
    protected void getBinding(FragmentTruckDetailsBinding binding) {

        this.binding = binding;
    }

    @Override
    protected void getViewModel(TruckDetailsViewModel viewModel) {

        this.viewModel = viewModel;
    }


    @Override
    protected void init() {

        navController = Navigation.findNavController(requireView());


       /* binding.imgTruckFront.setOnClickListener(v -> getUploadImageFile("TruckFront"));
        binding.imgTruckSide.setOnClickListener(v -> getUploadImageFile("TruckSide"));
        binding.imgTruckBack.setOnClickListener(v -> getUploadImageFile("TruckBack"));
        binding.imgRcFront.setOnClickListener(v -> getUploadImageFile("RC"));


        else if (uploadImageFor.equalsIgnoreCase("TruckFront")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgTruckFront);
            binding.imgTruckFront.setText("File uploaded");
            prefManager.put(Constants.DKYC_TRUCKFRONT, uploadFileResponse.getKeys().get(0));
        } else if (uploadImageFor.equalsIgnoreCase("TruckSide")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgTruckSide);
            binding.imgTruckSide.setText("File uploaded");
            prefManager.put(Constants.DKYC_TRUCKSIDE, uploadFileResponse.getKeys().get(0));
        } else if (uploadImageFor.equalsIgnoreCase("TruckBack")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgTruckBack);
            binding.imgTruckBack.setText("File uploaded");
            prefManager.put(Constants.DKYC_TRUCKBACK, uploadFileResponse.getKeys().get(0));
        } else if (uploadImageFor.equalsIgnoreCase("RC")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgRcFront);
            binding.imgRcFront.setText("File uploaded");
            prefManager.put(Constants.DKYC_RC, uploadFileResponse.getKeys().get(0));
        }*/

       binding.btnUpdateProfile.setOnClickListener(v ->  navController.navigate(R.id.action_truckDetails_to_driverProfileFragment));

    }
}
