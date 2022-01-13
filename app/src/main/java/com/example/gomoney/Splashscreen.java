package com.example.gomoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.example.gomoney.LoginActivity;
import com.example.gomoney.R;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        int load = 3000;

        new Handler().postDelayed(() -> {
            Intent SplashScreen = new Intent (this, LoginActivity.class);
            startActivity(SplashScreen);
            finish();
        },load);

    }
}