package com.example.btrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AllCategory extends AppCompatActivity {
    ImageView backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);
        backarrow= findViewById(R.id.back_pressed);
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllCategory.super.onBackPressed();
            }
        });
    }
}