package com.example.btrade;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class StartupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.startup_page);
    }

}

       /* public void callSignUpScreen(View view) {

            Intent intent = new Intent(getApplicationContext(), SignupActivity.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(findViewById(R.id.btn_signup), "transition_signup");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(StartupActivity.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }

        }
            }
        }
    }

    public void callLoginScreen(View view) {
    }*/


