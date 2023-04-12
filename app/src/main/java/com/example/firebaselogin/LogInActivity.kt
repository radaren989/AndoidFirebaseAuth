package com.example.firebaselogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaselogin.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity: AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnSubmit.setOnClickListener{
            val mail = binding.etMail.text.toString()
            val pass = binding.etPassword.text.toString()

            if(mail.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this@LogInActivity, "Fields are empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            firebaseAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener{
                if(it.isSuccessful){
                    val intent = Intent(this@LogInActivity, FinalActivity::class.java)
                    intent.putExtra("mail",mail)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this@LogInActivity, "Invalid mail or password", Toast.LENGTH_SHORT).show()
            }
        }

    }

}