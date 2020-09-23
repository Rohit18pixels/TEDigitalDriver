package com.jobportalemployer.asizone.view.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.jobportalemployer.asizone.R;


public class SplashActivity extends AppCompatActivity {

    Animation downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_splash_screen);

        downtoup = AnimationUtils.loadAnimation(this,R.anim.bottom_to_top);
        ImageView imgLogo = findViewById(R.id.imgLogo);
        imgLogo.setAnimation(downtoup);

        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            Intent i = new Intent(SplashActivity.this, AuthActivity.class);
            startActivity(i);
            finish();
        }, 5000);
    }
}
