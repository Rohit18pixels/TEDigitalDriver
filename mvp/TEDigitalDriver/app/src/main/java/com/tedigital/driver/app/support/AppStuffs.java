package com.tedigital.driver.app.support;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.LinearLayout;


import com.tedigital.driver.app.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by     : Kamlesh Yadav
 * Created on     : 7/30/2020.
 * Company        :Eighteen Pixels India Private Limited
 * Email          :kamlesh@18pixels.com
 */
public class AppStuffs {

    public static String currentDate() {

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");//2020-07-27T04:11:13.111Z
        return formatter.format(c);

    }

//    public static void CustomDialog(Context context, String Title, String Message) {
//        Dialog dialog_auth = new Dialog(context);
//        dialog_auth.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog_auth.setContentView(R.layout.custom_dialog_spinner);
//        dialog_auth.show();
//        dialog_auth.setCanceledOnTouchOutside(false);
//        dialog_auth.setCancelable(false);
//
//        Window window = dialog_auth.getWindow();
//        assert window != null;
//        window.setBackgroundDrawableResource(android.R.color.transparent);
//        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//
//    }

    public void alertBuilder(Context context, String[] label, String[] value) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(context);
        builderSingle.setTitle("Select Place");
        builderSingle.setItems(label, (dialogInterface, i) -> {
//            binding.truckType.setText(label[i]);
//            truck_type = label[i];
//            truck_type_value = value[i];
//            System.out.println("truck" + truck_type);
            dialogInterface.dismiss();

        });
        builderSingle.setNegativeButton("Back", (dialog, which) -> dialog.dismiss());
        builderSingle.show();
    }

//    public static String datePickers(Context context, SimpleDateFormat dateFormat) {
//        final Calendar calendar = Calendar.getInstance();
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int month = calendar.get(Calendar.MONTH);
//        int year = calendar.get(Calendar.YEAR);
//        // date picker dialog
//
//
//        DatePickerDialog picker = new DatePickerDialog(context, android.R.style.Theme_Holo_Dialog, (
//                view, year1, monthOfYear, dayOfMonth) -> getDateOnClick(year1, monthOfYear, dayOfMonth)
//                , year, month, day);
//
//        picker.show();
//
//        return dateFormat.format(getDateOnClick.getTime());
//    }


    public static boolean isValidPan(String pan) {
        Pattern mPattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");

        Matcher mMatcher = mPattern.matcher(pan);
        return mMatcher.matches();
    }


    public static boolean isValidEmail(String email) {
        Pattern mPattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");

        Matcher mMatcher = mPattern.matcher(email);
        return mMatcher.matches();
    }


    public static String currentDate(Context context, SimpleDateFormat dateFormat) {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        // date picker dialog

        String dateString = dateFormat.format(calendar.getTime());

        return dateString;
    }


}
