package com.tedigital.driver.app.ui.auth.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.tedigital.driver.app.R;
import com.tedigital.driver.app.databinding.FragmentUploadDocsBinding;
import com.tedigital.driver.app.support.AppStuffs;
import com.tedigital.driver.app.support.Constant;
import com.tedigital.driver.app.support.Constants;
import com.tedigital.driver.app.support.ImagePickerActivity;
import com.tedigital.driver.app.support.PrefManager;
import com.tedigital.driver.app.support.base.BaseFragment;
import com.tedigital.driver.app.ui.auth.viewmodel.UploadDocsViewModel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.tedigital.driver.app.ui.auth.fragment.RegistrationFragment.jsonArray;


public class UploadDocsFragment extends BaseFragment<FragmentUploadDocsBinding, UploadDocsViewModel> {

    private static final String TAG = UploadDocsFragment.class.getSimpleName();
    public static final int REQUEST_IMAGE = 100;
    private static String uploadImageFor = null;

    UploadDocsViewModel viewModel;
    FragmentUploadDocsBinding binding;
    private PrefManager prefManager;
    NavController navController;

    @Override
    protected Class<UploadDocsViewModel> setViewModel() {
        return UploadDocsViewModel.class;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_upload_docs;
    }

    @Override
    public String getTitle() {
        return "Upload Document";
    }

    @Override
    protected void getBinding(FragmentUploadDocsBinding binding) {

        this.binding = binding;
    }

    @Override
    protected void getViewModel(UploadDocsViewModel viewModel) {

        this.viewModel = viewModel;
    }

    @Override
    protected void init() {

        // Clearing older images from cache directory
        // don't call this line if you want to choose multiple images in the same activity
        // call this once the bitmap(s) usage is over
        navController = Navigation.findNavController(requireView());

        ImagePickerActivity.clearCache(requireContext());

        prefManager = PrefManager.getInstance(requireContext());

        binding.imgPan.setOnClickListener(v -> getUploadImageFile("PAN"));
        binding.imgAdhaarFront.setOnClickListener(v -> getUploadImageFile("AadharFront"));
        binding.imgAdhaarBack.setOnClickListener(v -> getUploadImageFile("AadharBack"));
        binding.imgLicenseFront.setOnClickListener(v -> getUploadImageFile("LicenseFront"));
        binding.imgLicenseBack.setOnClickListener(v -> getUploadImageFile("LicenseBack"));
        binding.imgSpecialLicense.setOnClickListener(v -> getUploadImageFile("SpecialLicense"));
        binding.imgSelfieTruck.setOnClickListener(v -> getUploadImageFile("Selfie"));


        binding.btnUpdateProfile.setOnClickListener(v -> getValidate());

        getPreferenceValues();
    }


    void getUploadImageFile(String imageFor) {
        Dexter.withActivity(requireActivity())
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            uploadImageFor = imageFor;
                            showImagePickerOptions();
//                            launchGalleryIntent();
                        }

                        if (report.isAnyPermissionPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void showImagePickerOptions() {
        ImagePickerActivity.showImagePickerOptions(requireContext(), new ImagePickerActivity.PickerOptionListener() {
            @Override
            public void onTakeCameraSelected() {
                launchCameraIntent();
            }

            @Override
            public void onChooseGallerySelected() {
                launchGalleryIntent();
            }
        });
    }

    private void loadProfile(Uri imageUri) {
        Log.d(TAG, "Image cache path: " + imageUri);

        File file = new File(Objects.requireNonNull(imageUri.getPath()));
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("parts", file.getName(), requestFile);

        viewModel.executeUploadFile(body);
        viewModel.getUploadFileResponseMutableLiveData().observe(this, uploadFileResponse -> {


            if (uploadImageFor.equalsIgnoreCase("PAN")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgPan);
                binding.imgPan.setText(splitString(uploadFileResponse.getKeys().get(0)));
                prefManager.put(Constants.DKYC_PAN, uploadFileResponse.getKeys().get(0));
            }
            else if (uploadImageFor.equalsIgnoreCase("AadharFront")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgAdhaarFront);


                binding.imgAdhaarFront.setText(splitString(uploadFileResponse.getKeys().get(0)));
                prefManager.put(Constants.DKYC_AADHARFRONT, uploadFileResponse.getKeys().get(0));
            }
            else if (uploadImageFor.equalsIgnoreCase("AadharBack")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgAdhaarBack);
                binding.imgAdhaarBack.setText(splitString(uploadFileResponse.getKeys().get(0)));
                prefManager.put(Constants.DKYC_AADHATBACK, uploadFileResponse.getKeys().get(0));

            }
            else if (uploadImageFor.equalsIgnoreCase("LicenseFront")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgLicenseFront);
                binding.imgLicenseFront.setText(splitString(uploadFileResponse.getKeys().get(0)));
                prefManager.put(Constants.DKYC_LICENSEFRONT, uploadFileResponse.getKeys().get(0));
            } else if (uploadImageFor.equalsIgnoreCase("LicenseBack")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgLicenseBack);
                binding.imgLicenseBack.setText(splitString(uploadFileResponse.getKeys().get(0)));
                prefManager.put(Constants.DKYC_LICENSEBACK, uploadFileResponse.getKeys().get(0));
            }
            else if (uploadImageFor.equalsIgnoreCase("SpecialLicense")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgLicenseBack);
                binding.imgSpecialLicense.setText(splitString(uploadFileResponse.getKeys().get(0)));
                prefManager.put(Constants.DUP_SPECIALLICENSE_KEY, uploadFileResponse.getKeys().get(0));
            }else if (uploadImageFor.equalsIgnoreCase("Selfie")) {
//            Glide.with(this).load(imageUri.toString()).into(binding.imgLicenseBack);
                binding.imgSelfieTruck.setText(splitString(uploadFileResponse.getKeys().get(0)));
                prefManager.put(Constants.DKYC_SELFIETRUCK, uploadFileResponse.getKeys().get(0));
            }

        });
//        binding.imgPan.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.transparent));


    }

    public String splitString(String s)
    {

        String[] separated = s.split("#");

        System.out.println("dasdsad"+separated[0]);
        return separated[0];
    }

    private void launchCameraIntent() {
        Intent intent = new Intent(requireActivity(), ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_IMAGE_CAPTURE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);

        // setting maximum bitmap width and height
        intent.putExtra(ImagePickerActivity.INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT, true);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_WIDTH, 1000);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_HEIGHT, 1000);

        startActivityForResult(intent, REQUEST_IMAGE);
    }

    private void launchGalleryIntent() {
        Intent intent = new Intent(requireActivity(), ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_GALLERY_IMAGE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
        startActivityForResult(intent, REQUEST_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getParcelableExtra("path");
                try {
                    // You can update this bitmap to your server
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireContext().getContentResolver(), uri);

                    // loading profile image from local cache
                    loadProfile(uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Showing Alert Dialog with Settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     *
     * @param
     */
    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(getString(R.string.dialog_permission_title));
        builder.setMessage(getString(R.string.dialog_permission_message));
        builder.setPositiveButton(getString(R.string.go_to_settings), (dialog, which) -> {
            dialog.cancel();
            openSettings();
        });
        builder.setNegativeButton(getString(android.R.string.cancel), (dialog, which) -> dialog.cancel());
        builder.show();

    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", requireActivity().getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    void getValidate() {

        binding.btnUpdateProfile.setVisibility(View.GONE);
        binding.progressBar.setVisibility(View.VISIBLE);

        String panNumber = binding.inputPanNumber.getText().toString();
        String aadharNumber = binding.inputAdhaar.getText().toString();
        String aadharNumberKeyFront = prefManager.get(Constants.DKYC_AADHARFRONT);
        String aadharNumberKeyBack = prefManager.get(Constants.DKYC_AADHATBACK);

        String specialLicense = binding.inputSpecialLicense.getText().toString();
        String licenseNumber = binding.inputLicense.getText().toString();
        String licenseNumberKeyFront = prefManager.get(Constants.DKYC_LICENSEFRONT);
        String licenseNumberKeyBack = prefManager.get(Constants.DKYC_LICENSEBACK);


        String truckKeyFront = prefManager.get(Constants.DKYC_TRUCKFRONT);
        String truckKeySide = prefManager.get(Constants.DKYC_TRUCKSIDE);
        String truckKeyBack = prefManager.get(Constants.DKYC_TRUCKBACK);

        String selfieWithTruck = prefManager.get(Constants.DKYC_SELFIETRUCK);

//        String rcNumber = binding.inputRcNumber.getText().toString();
        String rcKey = prefManager.get(Constants.DKYC_RC);


        if (inputValidate(licenseNumber) && inputValidate(licenseNumberKeyFront) && inputValidate(selfieWithTruck)) {
//
//                    if (inputValidate(panNumber))
//                        if (!AppStuffs.isValidPan(panNumber))
//                            showToast("Pan number is not valid", Constant.TOAST_ERROR);

            if(inputValidate(panNumber)){
                if(!AppStuffs.isValidPan(panNumber)){

                    binding.progressBar.setVisibility(View.GONE);
                    binding.btnUpdateProfile.setVisibility(View.VISIBLE);
                    showToast("Please enter proper pan number",Constant.TOAST_ERROR);
                    return;

                }
            }

            prefManager.put(Constants.DKYC_PANNUMBER, panNumber);
            prefManager.put(Constants.DKYC_AADHARNUMBER, aadharNumber);
            prefManager.put(Constants.DKYC_LICENSENUMBER, licenseNumber);
            prefManager.put(Constants.DUP_SPECIALLICENSE, specialLicense);

//            prefManager.put(Constants.DKYC_RCNUMBER, rcNumber);


            JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("id", prefManager.get(Constants.DRIVER_ID));
            jsonObject.addProperty("dob", prefManager.get(Constants.DUP_DOB));
            jsonObject.addProperty("bloodGroup", prefManager.get(Constants.DUP_BLOODGROUP));
            jsonObject.addProperty("address", prefManager.get(Constants.DUP_ADDRESS));

            jsonObject.addProperty("dlNumber", prefManager.get(Constants.DUP_DRIVINGLICENSE));
            jsonObject.addProperty("licenseValidity", prefManager.get(Constants.DUP_DRIVINGLICENSEVALIDITY));
            jsonObject.addProperty("yearOfExp", prefManager.get(Constants.DUP_DRIVEREXPERIENCE));
            jsonObject.addProperty("licenseCategory", prefManager.get(Constants.DUP_VEHICLELICENSETYPE));
            jsonObject.addProperty("specialLicense", prefManager.get(Constants.DUP_SPECIALLICENSE));
            jsonObject.addProperty("availabilty", "AVAILABLE");
            jsonObject.addProperty("policyInsuranceNumber", prefManager.get(Constants.DUP_INSURANCEPOLICY));
            jsonObject.addProperty("insuranceValidityDate", prefManager.get(Constants.DUP_INSURANCEPOLICYVALIDTY));
//            jsonObject.addProperty("driverId", prefManager.get(Constants.DRIVER_ID));
//            jsonObject.addProperty("userId", prefManager.get(Constants.DRIVER_ID));
            jsonObject.addProperty("driverName", prefManager.get(Constants.DUP_DRIVERNAME));
            jsonObject.addProperty("mobileNumber", prefManager.get(Constants.DUP_MOBILENUMBER));
            jsonObject.addProperty("aadharCardKey", prefManager.get(Constants.DKYC_AADHARFRONT));
            jsonObject.addProperty("licenseKey", prefManager.get(Constants.DKYC_LICENSEFRONT));
            jsonObject.addProperty("panNumberKey", prefManager.get(Constants.DKYC_PAN));
            jsonObject.addProperty("truckFrontPhotoKey", "");
            jsonObject.addProperty("truckBackPhotoKey", "");
            jsonObject.addProperty("truckSidePhotoKey", "");
            jsonObject.addProperty("truckRCFrontPhotoKey", "");
            jsonObject.addProperty("truckRCBackPhotoKey", "");
            jsonObject.addProperty("truckRCSidePhotoKey", "");
            jsonObject.addProperty("maritalStatus",  prefManager.get(Constants.DUP_MARITIAL_STATUS));

            jsonObject.addProperty("panNumber", panNumber);
            jsonObject.addProperty("licenseNumber", licenseNumber);
            jsonObject.addProperty("aadharNumber", aadharNumber);

            jsonObject.addProperty("specialLicencekey", prefManager.get(Constants.DUP_SPECIALLICENSE_KEY));
            jsonObject.addProperty("selfieWithTruckKey", prefManager.get(Constants.DKYC_SELFIETRUCK));
            jsonObject.addProperty("aadharBackImageKey", prefManager.get(Constants.DKYC_AADHATBACK));
            jsonObject.addProperty("driverProfileImageKey", "");
//            jsonObject.addProperty("truckNumber", truckNumber);
//            jsonObject.addProperty("truckRCNumber", rcNumber);

//            JsonArray array = new JsonArray();
//            array.add(prefManager.get(Constants.DUP_LANGUAGES_KNOWN));
//            array.add(prefManager.get(Constants.DUP_LAN_ENGLISH));


            JsonObject jsonObject1 = new JsonObject();
            jsonObject1.addProperty("label", prefManager.get(Constants.DUP_PHONETYPE));
            jsonObject1.addProperty("value", prefManager.get(Constants.DUP_PHONETYPE));

            jsonObject.add("phoneType", jsonObject1);
            jsonObject.add("languages", jsonArray);

            viewModel.executeUpdateProfile(prefManager.get(Constants.DRIVER_ID), jsonObject);
            viewModel.getError().observe(this, s -> {
                showToast(s, Constant.TOAST_ERROR);
                binding.btnUpdateProfile.setVisibility(View.VISIBLE);
                binding.progressBar.setVisibility(View.GONE);

            });

            viewModel.getRegistrationResonseMutableLiveData().observe(this, registrationResponce -> {
//                showToast("Your Profile update Successfully", Constant.TOAST_SUCCESS);
                binding.btnUpdateProfile.setVisibility(View.VISIBLE);
                binding.progressBar.setVisibility(View.GONE);

                prefManager.put(Constants.DRIVER_ID, registrationResponce.getDriverId());
                prefManager.put(Constants.USER_ID, registrationResponce.getUserId());
                navController.navigate(R.id.action_uploadDocs_to_truckDetails);
            });
        } else {
            showToast("Check the required fields", Constant.TOAST_ERROR);
            binding.btnUpdateProfile.setVisibility(View.VISIBLE);
            binding.progressBar.setVisibility(View.GONE);
        }
    }

    void getPreferenceValues() {
        binding.inputPanNumber.setText(prefManager.get(Constants.DKYC_PANNUMBER));
        binding.inputAdhaar.setText(prefManager.get(Constants.DKYC_AADHARNUMBER));
        binding.inputLicense.setText(prefManager.get(Constants.DKYC_LICENSENUMBER));
//        binding.inputTruckNumber.setText(prefManager.get(Constants.DKYC_TRUCKNUMBER));
//        binding.inputRcNumber.setText(prefManager.get(Constants.DKYC_RCNUMBER));

        binding.imgPan.setText(splitString(prefManager.get(Constants.DKYC_PAN)));
        binding.imgAdhaarFront.setText(splitString(prefManager.get(Constants.DKYC_AADHARFRONT)));
        binding.imgAdhaarBack.setText(splitString(prefManager.get(Constants.DKYC_AADHATBACK)));
        binding.imgLicenseFront.setText(splitString(prefManager.get(Constants.DKYC_LICENSEFRONT)));
        binding.imgLicenseBack.setText(splitString(prefManager.get(Constants.DKYC_LICENSEBACK)));
        binding.imgSelfieTruck.setText(splitString(prefManager.get(Constants.DKYC_SELFIETRUCK)));

//        binding.imgTruckFront.setText(prefManager.get(Constants.DKYC_TRUCKFRONT));
//        binding.imgTruckSide.setText(prefManager.get(Constants.DKYC_TRUCKSIDE));
//        binding.imgTruckBack.setText(prefManager.get(Constants.DKYC_TRUCKBACK));
//        binding.imgRcFront.setText(prefManager.get(Constants.DKYC_RC));
    }

}
