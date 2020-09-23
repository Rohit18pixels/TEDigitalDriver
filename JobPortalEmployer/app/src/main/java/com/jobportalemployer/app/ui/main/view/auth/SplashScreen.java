package com.jobportalemployer.app.ui.main.view.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.jobportalemployer.app.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;
    Animation topAnimantion,bottomAnimation,middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //INITIALIZATION

        findViewById(R.id.first_line).setAnimation(topAnimantion);
        findViewById(R.id.second_line).setAnimation(topAnimantion);
        findViewById(R.id.third_line).setAnimation(topAnimantion);
        findViewById(R.id.fourth_line).setAnimation(topAnimantion);
        findViewById(R.id.fifth_line).setAnimation(topAnimantion);
        findViewById(R.id.sixth_line).setAnimation(topAnimantion);
        findViewById(R.id.a).setAnimation(middleAnimation);
        findViewById(R.id.tagLine).setAnimation(bottomAnimation);


        //Animation Calls
        topAnimantion = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top);
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle);

        //Splash Screen Code to call new Activity after some time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Calling new Activity
                Intent intent = new Intent(SplashScreen.this, AuthActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}