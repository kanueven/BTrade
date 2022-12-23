package com.example.btrade.ui.activity.auth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btrade.R;

public class RegisterActivity extends AppCompatActivity {

    EditText user;
    EditText fname;
    EditText email;
    EditText ecountry;
    EditText ecity;
    EditText pass;
    Button reg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg = findViewById(R.id.register);
        user = findViewById(R.id.usernamereg);
        pass = findViewById(R.id.passreg);
    }
}