package com.machinetest.app.ui.splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.machinetest.app.R;
import com.machinetest.app.databinding.ActivitySplashScreenBinding;
import com.machinetest.app.support.base.BaseMvvmActivity;
import com.machinetest.app.ui.login.LoginActivity;
import com.machinetest.app.ui.user_list.MainActivity;


public class SplashActivity extends BaseMvvmActivity<SplashViewModel> {

    @Override
    protected void carls_configure(@Nullable Bundle savedInstanceState) {
        super.carls_configure(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.AppTheme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            if(mvvm.isUserLogged())
                carls_startActivity(MainActivity.class);
            else
                carls_startActivity(LoginActivity.class);
            finish();
        }, 5000);
    }

    @Override
    protected Class<SplashViewModel> createViewModelClass() {
        return SplashViewModel.class;
    }

    @Override
    protected void carls_bindViews() {
        ActivitySplashScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);

    }
}
