package com.machinetest.app.support;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.machinetest.app.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppStuffs {


    // IS INTERNET AVAILABLE
    public static boolean isNetworkAvailable(final Context ctx) {

        // INITIALIZATION
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        // RETURN
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }



    public static String getDateString(Date date, String format) {

//        Date date = new Date(datetime);

        return new SimpleDateFormat(format)
                .format(date);

    }

    public static void toast(View view, String message)
    {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    public static void Picasso(String image, ImageView imgView) {
        Picasso.get().load(image)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imgView);
    }

    public static void closeKeyboard(Activity context)
    {
        // this will give us the view
        // which is currently focus
        // in this layout
        View view = context.getCurrentFocus();

        // if nothing is currently
        // focus then this will protect
        // the app from crash
        if (view != null) {

            // now assign the system
            // service to InputMethodManager
            InputMethodManager manager
                    = (InputMethodManager)
                    context.getSystemService(
                            Context.INPUT_METHOD_SERVICE);
            manager
                    .hideSoftInputFromWindow(
                            view.getWindowToken(), 0);
        }
    }
}
