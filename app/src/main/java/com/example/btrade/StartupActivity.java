package com.example.btrade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btrade.activities.LoginActivity;
import com.example.btrade.activities.RegisterActivity;
import com.example.btrade.ui.product.ProductActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class StartupActivity extends AppCompatActivity {
    FirebaseAuth auth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(user == null || user.isAnonymous()){
            setContentView(R.layout.startup_page);
        }else {
            Intent intent = new Intent(this, ProductActivity.class);
            startActivity(intent);
        }

    }

    public void callSigninScreen(View view) {
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }

    public void callLoginScreen(View view) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }}

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


