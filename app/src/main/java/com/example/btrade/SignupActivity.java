package com.example.btrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity {
Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnregister=findViewById(R.id.btnregister);

    }
}