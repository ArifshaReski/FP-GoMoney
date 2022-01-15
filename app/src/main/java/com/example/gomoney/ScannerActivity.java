package com.example.gomoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ScannerActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        bottomNavigationView = findViewById(R.id.botomnav2);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(this, HomeActivity.class));
                    break;
                case R.id.profil:
                    startActivity(new Intent(this, ProfilActivity.class));
                    break;
            }
            return true;
        });
    }
}