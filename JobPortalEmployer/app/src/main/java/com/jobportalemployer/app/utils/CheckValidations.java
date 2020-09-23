package com.jobportalemployer.app.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import java.util.Objects;

public class CheckValidations {

    public CheckValidations( EditText editText, String error) {
    }

    public static boolean validate(Context context, EditText editText, String error) {
        String _editText = Objects.requireNonNull(editText.getText()).toString();

        if (TextUtils.isEmpty(_editText)) {
            editText.setError(error);
            return false;
        }

        else {
            return true;
        }


    }

}
