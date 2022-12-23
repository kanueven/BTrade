package com.example.btrade;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Chats extends AppCompatActivity {
    ImageView chat_backpressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        chat_backpressed=findViewById(R.id.chat_back_pressed);
        chat_backpressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chats.super.onBackPressed();
            }
        });

    }
}