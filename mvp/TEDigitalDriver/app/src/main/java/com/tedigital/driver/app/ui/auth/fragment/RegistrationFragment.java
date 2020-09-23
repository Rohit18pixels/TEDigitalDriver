package com.tedigital.driver.app.ui.auth.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.widget.EditText;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;
import com.tedigital.driver.app.R;
import com.tedigital.driver.app.databinding.FragmentRegistrationBinding;
import com.tedigital.driver.app.support.Constant;
import com.tedigital.driver.app.support.Constants;
import com.tedigital.driver.app.support.PrefManager;
import com.tedigital.driver.app.support.base.BaseFragment;
import com.tedigital.driver.app.ui.auth.viewmodel.RegistrationFragmentViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class RegistrationFragment extends BaseFragment<FragmentRegistrationBinding, RegistrationFragmentViewModel> {

    FragmentRegistrationBinding binding;
    RegistrationFragmentViewModel viewModel;
    private String phoneType = "";
    private String vehicleType = "";
    private String languageType = "";
    private String maritialStatusValue = "";
    private String bloodGroup = "";

    NavController navController;
    public static JsonArray jsonArray = new JsonArray();

    String[] valuePhoneTypes = {"Feature Phone", "Smart phone"};
    String[] labelPhoneTypes = {"Feature Phone", "Smart phone"};

    String valueVehicleLicenseType[] = {"LMV", "MGV", "HMV", "HGMV", "HPMV/ HPV", "Trailer"};
    String labelVehicleLicenseType[] = {"LMV", "MGV", "HMV", "HGMV", "HPMV/ HPV", "Trailer"};

    String labelLanguageType[] = {"English", "हिन्दी", "বাংলা", "मराठी", "ગુજરાતી", "ਪੰਜਾਬੀ", "മലയാളം", "ಕನ್ನಡ", "اردو"};


    String labelMaritialStatus[] = {"SINGLE", "MARRIED", "WIDOWED", "DIVORCED_SEPARATED"};/*{"Single", "Married", "Widowed", "Divorced/Separated"};*/
    String valueMaritialStatus[] = {"SINGLE", "MARRIED", "WIDOWED", "DIVORCED_SEPARATED"};

    String labelBloodGroup[] = {"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-", "other"};


    boolean checkStatusH = false;
    boolean checkStatusE = false;

    private PrefManager prefManager;
    private String hindi;
    private String english;
    private String bengali;
    private String marathi;
    private String gujrati;
    private String punjabi;
    private String malyalam;
    private String kannad;
    private String urdu;

    private static int position = -1;

    private RecyclerView rvLanguageKnown;
//    private PrefManager prefManager;

    @Override
    protected Class<RegistrationFragmentViewModel> setViewModel() {
        return RegistrationFragmentViewModel.class;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_registration;
    }

    @Override
    public String getTitle() {
        return "Registration Form";
    }

    @Override
    protected void getBinding(FragmentRegistrationBinding binding) {

        this.binding = binding;
    }

    @Override
    protected void getViewModel(RegistrationFragmentViewModel viewModel) {
        this.viewModel = viewModel;

    }


    @Override
    protected void init() {

        prefManager = PrefManager.getInstance(requireContext());

        navController = Navigation.findNavController(requireView());
        binding.inputDob.setOnClickListener(v -> datePickerAdult(binding.inputDob));

        binding.btnUpdateProfile.setOnClickListener(v -> getValidate());

//        binding.inputInsuranceDate.setOnClickListener(v -> datePicker(binding.inputInsuranceDate));
        binding.inputValidityDl.setOnClickListener(v -> datePicker(binding.inputValidityDl));

      /*  binding.inputVehicleLicenceCat.setOnClickListener(v ->
                spinnerList(labelVehicleLicenseType, valueVehicleLicenseType, binding.inputVehicleLicenceCat, vehicleType));*/

       /* binding.inputPhoneType.setOnClickListener(v ->
                spinnerList(labelPhoneTypes, valuePhoneTypes, binding.inputPhoneType, phoneType));*/
      /*  binding.inputMaritialStatus.setOnClickListener(v ->
                spinnerListMaritialStatus(labelMaritialStatus, valueMaritialStatus, binding.inputMaritialStatus, maritialStatusValue));*/
        binding.inputBloodGroup.setOnClickListener(v ->
                spinnerList(labelBloodGroup, valuePhoneTypes, binding.inputBloodGroup, bloodGroup));

        binding.inputLanguageType.setOnClickListener(v -> {
            spinnerList(labelLanguageType, valuePhoneTypes, binding.inputLanguageType, languageType);
        });

        for(int i=0; i<jsonArray.size(); i++)
        {
            if (jsonArray.get(i).getAsString().equalsIgnoreCase("English"))
                binding.chipEnglish.setChecked(true);
            else if (jsonArray.get(i).getAsString().equalsIgnoreCase("हिन्दी"))
                binding.chipHindi.setChecked(true);
            else if (jsonArray.get(i).getAsString().equalsIgnoreCase("বাংলা"))
                binding.chipBengali.setChecked(true);
            else if (jsonArray.get(i).getAsString().equalsIgnoreCase("मराठी"))
                binding.chipMarathi.setChecked(true);
           else if (jsonArray.get(i).getAsString().equalsIgnoreCase("ગુજરાતી"))
                binding.chipGujrati.setChecked(true);
           else if (jsonArray.get(i).getAsString().equalsIgnoreCase("ਪੰਜਾਬੀ"))
                binding.chipPunjabi.setChecked(true);
           else if (jsonArray.get(i).getAsString().equalsIgnoreCase("മലയാളം"))
                binding.chipMalyalm.setChecked(true);
           else if (jsonArray.get(i).getAsString().equalsIgnoreCase("ಕನ್ನಡ"))
                binding.chipKannad.setChecked(true);
           else if (jsonArray.get(i).getAsString().equalsIgnoreCase("اردو"))
                binding.chipUrdu.setChecked(true);
        }

        binding.chipEnglish.setOnClickListener(v -> {
            if (binding.chipEnglish.isChecked()) {
                english = "English";
                jsonArray.add(english);

            } else

                for (int i = 0; i < jsonArray.size(); i++)
                    if (jsonArray.get(i).getAsString().equalsIgnoreCase("English"))
                        jsonArray.remove(i);


        });

        binding.chipHindi.setOnClickListener(v -> {
            if (binding.chipHindi.isChecked()) {
                hindi = "हिन्दी";
                jsonArray.add(hindi);

            } else

                for (int i = 0; i < jsonArray.size(); i++)
                    if (jsonArray.get(i).getAsString().equalsIgnoreCase("हिन्दी"))
                        jsonArray.remove(i);


        });

        binding.chipBengali.setOnClickListener(v -> {
            if (binding.chipBengali.isChecked()) {
                bengali = "বাংলা";
                jsonArray.add(bengali);
            } else

                for (int i = 0; i < jsonArray.size(); i++)
                    if (jsonArray.get(i).getAsString().equalsIgnoreCase("বাংলা"))
                        jsonArray.remove(i);


        });

        binding.chipMarathi.setOnClickListener(v -> {
            if (binding.chipMarathi.isChecked()) {
                marathi = "मराठी";
                jsonArray.add(marathi);
            } else

                for (int i = 0; i < jsonArray.size(); i++)
                    if (jsonArray.get(i).getAsString().equalsIgnoreCase("मराठी")) {
                        jsonArray.remove(i);

                    }
        });

        binding.chipGujrati.setOnClickListener(v -> {
            if (binding.chipGujrati.isChecked()) {
                gujrati = "ગુજરાતી";
                jsonArray.add(gujrati);
            } else

                for (int i = 0; i < jsonArray.size(); i++)
                    if (jsonArray.get(i).getAsString().equalsIgnoreCase("ગુજરાતી"))
                        jsonArray.remove(i);

        });


        binding.chipPunjabi.setOnClickListener(v -> {
            if (binding.chipPunjabi.isChecked()) {
                punjabi = "ਪੰਜਾਬੀ";
                jsonArray.add(punjabi);
            } else

                for (int i = 0; i < jsonArray.size(); i++)
                    if (jsonArray.get(i).getAsString().equalsIgnoreCase("ਪੰਜਾਬੀ"))
                        jsonArray.remove(i);


        });

        binding.chipMalyalm.setOnClickListener(v -> {
            if (binding.chipMalyalm.isChecked()) {
                malyalam = "മലയാളം";
                jsonArray.add(malyalam);
            } else

                for (int i = 0; i < jsonArray.size(); i++)
                    if (jsonArray.get(i).getAsString().equalsIgnoreCase("മലയാളം"))
                        jsonArray.remove(i);

        });


        binding.chipKannad.setOnClickListener(v -> {
            if (binding.chipKannad.isChecked()) {
                kannad = "ಕನ್ನಡ";
                jsonArray.add(kannad);
            } else


                for (int i = 0; i < jsonArray.size(); i++)

                    if (jsonArray.get(i).getAsString().equalsIgnoreCase("ಕನ್ನಡ"))
                        jsonArray.remove(i);


        });

        binding.chipUrdu.setOnClickListener(v -> {
            if (binding.chipUrdu.isChecked()) {
                urdu = "اردو";
                jsonArray.add(urdu);
            } else

                for (int i = 0; i < jsonArray.size(); i++)

                    if (jsonArray.get(i).getAsString().equalsIgnoreCase("اردو"))
                        jsonArray.remove(i);


        });

        getPreferencesValues();
    }


    public void datePickerAdult(EditText editText) {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        // date picker dialog


        DatePickerDialog picker = new DatePickerDialog(requireContext(), android.R.style.Theme_Holo_Dialog, (
                view, year1, monthOfYear, dayOfMonth) -> {

            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(year1, monthOfYear, dayOfMonth);

            Calendar minAdultAge = new GregorianCalendar();
            minAdultAge.add(Calendar.YEAR, -18);

            if (minAdultAge.before(calendar2)) {
                showToast("Age should be greater than 18", Constant.TOAST_ERROR);
            } else {
                @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.SERVERDATE);
                String dateString = dateFormat.format(calendar2.getTime());
                editText.setText(dateString);
            }

        }
                , year, month, day);

        picker.show();

    }

    public void datePicker(EditText editText) {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        // date picker dialog


        DatePickerDialog picker = new DatePickerDialog(requireContext(), android.R.style.Theme_Holo_Dialog, (
                view, year1, monthOfYear, dayOfMonth) -> {

            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(year1, monthOfYear, dayOfMonth);

            @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.SERVERDATE);
            String dateString = dateFormat.format(calendar2.getTime());
            editText.setText(dateString);

        }
                , year, month, day);

        picker.show();

    }

    public void getValidate() {


        System.out.println("jbdskajdf" + jsonArray);

        String dob = binding.inputDob.getText().toString();
        String bloodGroup = binding.inputBloodGroup.getText().toString();
        String address = binding.inputAddress.getText().toString();
        String drivingLicense = binding.inputDrivingLicense.getText().toString();

        String validitydrivingLicense = binding.inputValidityDl.getText().toString();

        String experience = binding.inputExperience.getText().toString();

        String vehicleLicensetype = binding.inputVehicleLicenceCat.getText().toString();

        String specialLicence = binding.inputSpecialLicense.getText().toString();

        String policyInsuranceNum = binding.inputPolicyInsuranceNumber.getText().toString();

        String insuranceValidity = binding.inputInsuranceDate.getText().toString();
        String mobileNumber = binding.inputMobileNumber.getText().toString();
        String driverName = binding.inputDriverName.getText().toString();

        String phoneType = Objects.requireNonNull(binding.inputPhoneType.getText()).toString();
        String languageKnown = Objects.requireNonNull(binding.inputLanguageType.getText()).toString();
        String maritialStatus = Objects.requireNonNull(binding.inputMaritialStatus.getText()).toString();


        if (inputValidate(dob)
                && inputValidate(bloodGroup)
                && inputValidate(drivingLicense)
                && inputValidate(validitydrivingLicense)
                && inputValidate(experience)
                && inputValidate(vehicleLicensetype)
                && inputValidate(phoneType)
                && inputValidate(mobileNumber)
                && inputValidate(driverName)
                && inputValidate(languageKnown)) {

            prefManager.put(Constants.DUP_DOB, dob);
            prefManager.put(Constants.DUP_ADDRESS, address);
            prefManager.put(Constants.DUP_BLOODGROUP, bloodGroup);
            prefManager.put(Constants.DUP_DRIVEREXPERIENCE, experience);
            prefManager.put(Constants.DUP_DRIVERNAME, driverName);
            prefManager.put(Constants.DUP_DRIVINGLICENSE, drivingLicense);
            prefManager.put(Constants.DUP_DRIVINGLICENSEVALIDITY, validitydrivingLicense);
            prefManager.put(Constants.DUP_INSURANCEPOLICY, policyInsuranceNum);
            prefManager.put(Constants.DUP_INSURANCEPOLICYVALIDTY, insuranceValidity);
            prefManager.put(Constants.DUP_MOBILENUMBER, mobileNumber);
            prefManager.put(Constants.DUP_PHONETYPE, phoneType);
            prefManager.put(Constants.DUP_SPECIALLICENSE, specialLicence);
            prefManager.put(Constants.DUP_VEHICLELICENSETYPE, vehicleLicensetype);

            prefManager.put(Constants.DUP_LANGUAGES_KNOWN, languageKnown);
            prefManager.put(Constants.DUP_MARITIAL_STATUS, maritialStatus);
//            prefManager.put(Constants.DUP_MARITIAL_STATUS_VALUE, maritialStatusValue);

            navController.navigate(R.id.action_registrationFragment_to_uploadDocs);

        } else

            showToast("Please check mandatory fields", Constant.TOAST_ERROR);

    }


    public void spinnerList(String[] label, String[] value, EditText editText, String vehicleType) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
        builderSingle.setTitle("---Select Category---");

        builderSingle.setItems(label, (dialogInterface, i) -> {
            editText.setText(label[i]);

            dialogInterface.dismiss();

        });
        builderSingle.setNegativeButton("Back", (dialog, which) -> dialog.dismiss());
        builderSingle.show();
    }

    public void spinnerListMaritialStatus(String[] label, String[] value, EditText editText, String vehicleType) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
        builderSingle.setTitle("---Select Category---");

        builderSingle.setItems(label, (dialogInterface, i) -> {
            editText.setText(label[i]);

//            maritialStatusValue = value[i];
            dialogInterface.dismiss();

        });
        builderSingle.setNegativeButton("Back", (dialog, which) -> dialog.dismiss());
        builderSingle.show();
    }


    public void getPreferencesValues() {
        binding.inputDriverName.setText(prefManager.get(Constants.DUP_DRIVERNAME));
        binding.inputMobileNumber.setText(prefManager.get(Constants.DUP_MOBILENUMBER));
        binding.inputPhoneType.setText(prefManager.get(Constants.DUP_PHONETYPE));
        binding.inputVehicleLicenceCat.setText(prefManager.get(Constants.DUP_VEHICLELICENSETYPE));
        binding.inputPolicyInsuranceNumber.setText(prefManager.get(Constants.DUP_INSURANCEPOLICY));
        binding.inputDob.setText(prefManager.get(Constants.DUP_DOB));
        binding.inputSpecialLicense.setText(prefManager.get(Constants.DUP_SPECIALLICENSE));
        binding.inputAddress.setText(prefManager.get(Constants.DUP_ADDRESS));
        binding.inputExperience.setText(prefManager.get(Constants.DUP_DRIVEREXPERIENCE));
        binding.inputDrivingLicense.setText(prefManager.get(Constants.DUP_DRIVINGLICENSE));
        binding.inputInsuranceDate.setText(prefManager.get(Constants.DUP_INSURANCEPOLICYVALIDTY));
        binding.inputValidityDl.setText(prefManager.get(Constants.DUP_DRIVINGLICENSEVALIDITY));
        binding.inputBloodGroup.setText(prefManager.get(Constants.DUP_BLOODGROUP));
        binding.inputAddress.setText(prefManager.get(Constants.DUP_ADDRESS));
        binding.inputLanguageType.setText(prefManager.get(Constants.DUP_LANGUAGES_KNOWN));
        binding.inputMaritialStatus.setText(prefManager.get(Constants.DUP_MARITIAL_STATUS));


    }

}
