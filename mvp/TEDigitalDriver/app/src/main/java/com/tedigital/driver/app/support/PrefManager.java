package com.tedigital.driver.app.support;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by     : Kamlesh Yadav
 * Created on     : 7/31/2020.
 * Company        :Eighteen Pixels India Private Limited
 * Email          :kamlesh@18pixels.com
 */
public class PrefManager {

    private static PrefManager prefManager;
    private SharedPreferences SP;
    private static String filename="TransportExchange";
    public static int theme=1;

    private PrefManager(Context context) {
        SP = context.getApplicationContext().getSharedPreferences(filename,0);
    }

    public static PrefManager getInstance(Context context) {
        if (prefManager == null) {
            prefManager = new PrefManager(context);
        }
        return prefManager;
    }

    public void put(String key, String value) {
        SharedPreferences.Editor editor;
        editor = SP.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void putbool(String key, boolean value) {
        SharedPreferences.Editor editor;
        editor = SP.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }



    public boolean getbool(String key) {
        return SP.getBoolean(key, false);
    }

    public String get(String key) {
        return SP.getString(key, null);
    }

    public int getInt(String key) {
        return SP.getInt(key, 0);
    }

    public void putInt(String key, int num) {
        SharedPreferences.Editor editor;
        editor = SP.edit();

        editor.putInt(key, num);
        editor.apply();
    }

    public void clear(){
        SharedPreferences.Editor editor;
        editor = SP.edit();

        editor.clear();
        editor.apply();
    }

    public void remove(){
        SharedPreferences.Editor editor;
        editor = SP.edit();

        editor.remove(filename);
        editor.apply();
    }
}
