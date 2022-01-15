package com.example.gomoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gomoney.Data.DAO.UserDAO;
import com.example.gomoney.Data.Database.MyApp;
import com.example.gomoney.Data.Model.User;

public class LoginActivity<btnLogin> extends AppCompatActivity {

    Button btnLogin;
    Button btnRegister;
    EditText User,pass;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        User = findViewById(R.id.etEmail);
        pass = findViewById(R.id.etPassword);
        userDAO = MyApp.db.userDAO();

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view -> {

            String email = User.getText().toString();
            String psw = pass.getText().toString();
            User user = userDAO.login(email,psw);
            if (user != null && Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                Toast.makeText(LoginActivity.this,"Login berhasil", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,HomeActivity.class));
            }

            else {
                Toast.makeText(this,"Masukan email dengan benar", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this,RegistrasiActivity.class)));

    }
}

