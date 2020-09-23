package com.jobportalemployer.asizone.presenter.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Locale;


//Created by Akash Kumar (Android Developer) on 21 / 11 / 2019 .
//Copyright (c) 2019 . All rights reserved.

public class CustomPerference {

    SharedPreferences sharedpreferences,sp;


    public static final String MyPREFERENCES = "UIGlobe06102020" ;
    private Context context;


    public CustomPerference(Context context){
        this.context = context;
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        int val = sharedpreferences.getInt(key, 0);
        return val;
    }
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        boolean val = sharedpreferences.getBoolean(key, false);
        return val;

    }

    public static String getString(Context context, String key) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String val = sharedpreferences.getString(key, null);
        return val;
    }

    public static void remove(Context context, String key) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove(key);
        editor.apply();
    }
    public static void removeALL(Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.apply();
    }

    public static void clearPref(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}
