package com.example.gomoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfilActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        bottomNavigationView = findViewById(R.id.botomnav1);

        logout = findViewById(R.id.btnLogout);

        logout.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(this, HomeActivity.class));
                    break;

                case R.id.scan:
                    startActivity(new Intent(this, ScannerActivity.class));
                    break;
            }
            return true;
        });
    }
}