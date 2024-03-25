package com.gangulytpoint.mindfulmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shashank.sony.fancytoastlib.FancyToast;

import static androidx.core.content.ContentProviderCompat.requireContext;

public class Login extends AppCompatActivity {
    EditText etName, etPass;
    Button login;
    TextView register;
    String name, password;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etName = findViewById(R.id.login_name);
        etPass = findViewById(R.id.login_pass);
        login = findViewById(R.id.login_loginbtn);
        register = findViewById(R.id.login_register);
        login.setOnClickListener(v -> {
            name = etName.getText().toString();
            password = etPass.getText().toString();
            if (!name.equals("") && !password.equals("")) {
                preferences = getSharedPreferences("data", 0);
                final String savedName = preferences.getString("name", "");
                final String savedPassword = preferences.getString("password", "");
                if (name.equals(savedName) && password.equals(savedPassword)) {
                    startActivity(new Intent(getApplicationContext(), ItemsCategory.class));
                    finish();
                }
                else {
                    FancyToast.makeText(getApplicationContext(), "Name or password is wrong", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                }
            }
            else {
                FancyToast.makeText(getApplicationContext(), "The fields should not be empty", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
            }
        });
        register.setOnClickListener(v -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(new RegisterFragment(), "Register Fragment").commit();
        });
    }
}