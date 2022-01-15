package com.example.gomoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gomoney.Data.DAO.UserDAO;
import com.example.gomoney.Data.Database.MyApp;
import com.example.gomoney.Data.Model.User;

import java.util.regex.Pattern;

public class RegistrasiActivity extends AppCompatActivity {

    Button btnRegister1;
    TextView login;

    EditText Email, User,pass, confrim;
    UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        btnRegister1 = findViewById(R.id.btnRegister1);
        login = findViewById(R.id.akun);
        Email = findViewById(R.id.etEmail1);
        User = findViewById(R.id.etUsername);
        pass = findViewById(R.id.etPassword1);
        confrim = findViewById(R.id.etConfirm);
        userDAO = MyApp.db.userDAO();

        btnRegister1.setOnClickListener(view -> {
            String email = Email.getText().toString();
            String psw = pass.getText().toString();
            String confr = confrim.getText().toString();

            if(psw.length() == 0 && confr.length() == 0){
                pass.setError("Password tidak boleh kosong!");
            } else if (!psw.equals(confr)) {
                confrim.setError("Confirmasi Password Salah");
            } else if (psw.equals(confr) && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                User user = new User(email,psw);
                userDAO.Register(user);
                Toast.makeText(this,"Registrasi berhasil", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,LoginActivity.class));
            }
            else {
                Toast.makeText(this,"Masukan email dengan benar", Toast.LENGTH_SHORT).show();
            }

        });

        login.setOnClickListener(view -> {
            startActivity(new Intent(this,LoginActivity.class));
        });

    }
}