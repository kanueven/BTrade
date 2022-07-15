package com.example.btrade

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.btrade.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnCreate.setOnClickListener(this)
        binding.btnLogIn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            binding.btnCreate.id -> {
                val intent = Intent(this,RegisterActivity::class.java)
                startActivity(intent)
            }
            binding.btnLogIn.id -> {
                val email = binding.edtEmailLogin.text.toString()
                val pass = binding.edtPassword.text.toString()
                if (validate(email,pass)){
                    auth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener {
                            if (it.isSuccessful){
                                val intent = Intent(this,DashboardActivity::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                }else{
                    Toast.makeText(this, "Blank fields", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    private fun validate(email: String?, pass: String?): Boolean {
        return !(email.isNullOrEmpty() or pass.isNullOrEmpty())
    }
}