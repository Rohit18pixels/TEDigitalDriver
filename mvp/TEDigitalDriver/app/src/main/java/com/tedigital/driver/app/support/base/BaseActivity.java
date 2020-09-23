package com.tedigital.driver.app.support.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.fxn.cue.Cue;
import com.fxn.cue.enums.Duration;
import com.fxn.cue.enums.Type;
import com.tedigital.driver.app.support.Constant;
import com.tedigital.driver.app.support.Utilities;

import java.util.Objects;

public abstract class BaseActivity<B extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity {

    private B binding;
    private V viewModel;
    private Dialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        viewModel = null;
        System.gc();
    }

    private Context getContext() {
        return this;
    }

    private void setUp() {
        dialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        binding = DataBindingUtil.setContentView(this, getLayout());
        viewModel = new ViewModelProvider(this).get(setViewModel());
        if (getBindingVariable() != 0)
            binding.setVariable(getBindingVariable(), viewModel);
        binding.executePendingBindings();
        getBinding(binding);
        getViewModel(viewModel);
    }

//    public void showLoader() {
//        ProgressDialogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.progress_dialog, null, false);
//        dialog.setContentView(binding.getRoot());
//        dialog.setCancelable(false);
//        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
//        Glide.with(this).asGif().load(R.raw.loader).into(binding.loader);
//        dialog.show();
//    }

    public void hideLoader() {
        if (dialog.isShowing())
            dialog.dismiss();
    }

    public int getBindingVariable() {
        return 0;
    }

    @LayoutRes
    public abstract int getLayout();

    protected abstract void getBinding(B binding);

    protected abstract void getViewModel(V viewModel);

    protected abstract Class<V> setViewModel();

    protected abstract void init();

    public void showToast(String message, String type) {
        if (type.equalsIgnoreCase(Constant.TOAST_SUCCESS)) {
            Cue.init().with(getContext())
                    .setMessage(message)
                    .setType(Type.SUCCESS)
                    .setGravity(Gravity.BOTTOM)
                    .setPadding(20)
                    .setDuration(Duration.LONG)
                    .show();
        } else if (type.equalsIgnoreCase(Constant.TOAST_ERROR)) {
            Utilities.vibrate(getContext());
            Cue.init().with(getContext())
                    .setMessage(message)
                    .setType(Type.DANGER)
                    .setGravity(Gravity.BOTTOM)
                    .setPadding(20)
                    .setDuration(Duration.LONG)
                    .show();
        } else {
            Cue.init().with(getContext())
                    .setMessage(message)
                    .setType(Type.DARK)
                    .setGravity(Gravity.BOTTOM)
                    .setPadding(20)
                    .setDuration(Duration.LONG)
                    .show();
        }
    }

    public void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = Objects.requireNonNull(connectivityManager).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public <C extends Activity> void refreshActivity() {
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

    public <C extends Activity> void startActivity(Class<C> targetActivityClass) {
        Intent intent = new Intent(this, targetActivityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public <C extends Activity> void startActivityWithBundle(Class<C> targetActivityClass, Bundle bundle) {
        Intent intent = new Intent(this, targetActivityClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public boolean inputValidate(String editText)
    {
        if (TextUtils.isEmpty(editText))
            return false;
        else
            return true;

    }
}
