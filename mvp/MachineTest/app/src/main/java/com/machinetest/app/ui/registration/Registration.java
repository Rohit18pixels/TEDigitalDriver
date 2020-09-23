package com.machinetest.app.ui.registration;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.machinetest.app.R;
import com.machinetest.app.databinding.ActivityRegistrationBinding;
import com.machinetest.app.support.AppStuffs;
import com.machinetest.app.support.Constants;
import com.machinetest.app.support.base.BaseMvvmActivity;
import com.machinetest.app.ui.login.LoginActivity;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Objects;

public class Registration extends BaseMvvmActivity<RegistrationViewModel> {

//    private Repository repository;


    ActivityRegistrationBinding binding;
    private DatePickerDialog datePickerDialog;
    private String sendDate;
    private String _gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);

//        List<User> list = mvvm.getList();
        /*
         *        This code provide us data in json formta
         * */
//        if(list.isEmpty()){
//
//        }else {
//
//            Gson gson = new Gson();
//            String   data= gson.toJson(list); // Show list in JSON format ....
//
//        }

        // Button submit data for Registration
        binding.radioGrp.setOnCheckedChangeListener((group, checkedId) -> {
            if(binding.rbtnMale.isChecked())
                _gender = "Male";
            else
                _gender = "Female";
        });
        binding.btnNavigate.setOnClickListener(v -> {
            if (AppStuffs.isNetworkAvailable(this)) {

                if(!validate())
                {
                    binding.indeterminateBar.setVisibility(View.GONE);
                    binding.btnNavigate.setVisibility(View.VISIBLE);
                }

                else {
                    binding.indeterminateBar.setVisibility(View.VISIBLE);
                    binding.btnNavigate.setVisibility(View.GONE);
                }
            } else
                Snackbar.make(binding.scrollView, "Check internet connectivity", BaseTransientBottomBar.LENGTH_LONG).isShown();
        });

//        binding.edtDob.setOnClickListener(v -> {
//            AppStuffs.closeKeyboard(Registration.this);
//            getDateCalendar();
//            datePickerDialog.show();
//        });
    }

    @Override
    protected void carls_bindViews() {

    }

    @Override
    protected Class<RegistrationViewModel> createViewModelClass() {
        return RegistrationViewModel.class;
    }

    public boolean validate() {

        String _username = Objects.requireNonNull(binding.edtUserName.getText()).toString();
        String _fullname = Objects.requireNonNull(binding.edtFullName.getText()).toString();
        String _phone = Objects.requireNonNull(binding.edtPhone.getText()).toString();
        String _dob = Objects.requireNonNull(binding.edtDob.getText()).toString();
        
        String _password = Objects.requireNonNull(binding.edtPassword.getText()).toString();
        String _con_password = Objects.requireNonNull(binding.edtConPass.getText()).toString();


        if (TextUtils.isEmpty(_username)) {
            binding.edtUserName.setError("Enter unique user name");
            return false;
        } else if (TextUtils.isEmpty(_fullname)) {
            binding.edtFullName.setError("Enter Full Name");
            return false;
        } else if (TextUtils.isEmpty(_phone)) {
            binding.edtPhone.setError("Enter Phone number");
            return false;
        } else if (TextUtils.isEmpty(_dob)) {
            binding.edtDob.setError("Enter your Date Of Birth");
            return false;
        } else if (TextUtils.isEmpty(_password)) {
            binding.edtPassword.setError("Enter Password");
            return false;
        } else if (TextUtils.isEmpty(_con_password)) {
            binding.edtConPass.setError("Enter Confirm Password");
            return false;
        }
        else if(!_con_password.equalsIgnoreCase(_password))
        {
            AppStuffs.toast(binding.scrollView, "Password doesn't match");
            return false;

        } else {

            Long value = mvvm.registration(_username, _fullname, _phone, _dob, _gender, _password);
            if (value > 0) {

                carls_startActivity(LoginActivity.class);
                System.out.println("data"+value);


            } else {
                System.out.println("data"+value);

                binding.indeterminateBar.setVisibility(View.GONE);
                binding.btnNavigate.setVisibility(View.VISIBLE);
                AppStuffs.toast(binding.scrollView, "User already exist...");
            }
        }

            //failed

//            /*Long value = mvvm.registration(_username, _fullname, _phone, _dob, _gender, _password);
            return true;
        }

    void getDateCalendar()
    {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this,
                (view, year, monthOfYear, dayOfMonth) ->
                {

                    // GET CALENDAR INSTANCE
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);

                    // SET VALUES
                    sendDate = Constants.dateFormatterYear.format(newDate.getTime());
                    binding.edtDob.setText(Constants.dateFormatter.format(newDate.getTime()));

                },
                newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

        try {

            // Here to set maximum age limit
            datePickerDialog.getDatePicker().setMinDate(Constants.dateFormatter.parse("01/01/1950").getTime());
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.updateDate(1950,01,01);

        } catch (ParseException ignored) {}


    }

}