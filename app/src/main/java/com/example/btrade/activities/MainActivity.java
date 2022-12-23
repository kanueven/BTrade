package com.example.btrade.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btrade.R;

public class MainActivity extends AppCompatActivity {
   ImageView backgroundimg;
   TextView txt,text2;
   Animation side,bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundimg=findViewById(R.id.background_image);
        txt=findViewById(R.id.messgae);
        text2=findViewById(R.id.clickhere);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this
                        ,DashboardActivity.class);
                startActivity(intent);
            }
        });
        
//createanimations



    }
}