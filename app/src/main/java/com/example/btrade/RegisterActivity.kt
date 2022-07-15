package com.example.btrade

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.btrade.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnregister.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            binding.btnregister.id -> {
                val username:String = binding.edtUname.text.toString()
                val email:String = binding.edtEmail.text.toString()
                val pass:String = binding.edtPass.text.toString()

                if (validate(username,email,pass)){
                    auth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful){
                                auth.signInWithEmailAndPassword(email,pass)
                                    .addOnCompleteListener {
                                        if (task.isSuccessful){
                                            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                                            val intent = Intent(this,DashboardActivity::class.java)
                                            startActivity(intent)
                                        }
                                    }
                            }else{
                                Toast.makeText(this, "Email already exists", Toast.LENGTH_SHORT).show()

                            }
                        }
                }

            }
        }
    }
    private fun validate(username:String?,email:String?, pass:String?):Boolean{
        if ((email.isNullOrBlank() or email.isNullOrEmpty())){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show()
        }else if (username.isNullOrBlank() or username.isNullOrEmpty()){
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show()
        }else if (pass.isNullOrBlank() or pass.isNullOrEmpty()){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show()
        }else{
            return true
        }
        return false
    }
}