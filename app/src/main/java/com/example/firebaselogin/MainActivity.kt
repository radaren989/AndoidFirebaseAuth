package com.example.firebaselogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.widget.Toast
import com.example.firebaselogin.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLoginScreen.setOnClickListener{
            val intent = Intent(this@MainActivity, LogInActivity::class.java)
            startActivity(intent)
        }
        binding.btnSubmit.setOnClickListener{
            val mail = binding.etMail.text.toString()
            val pass = binding.etPassword.text.toString()

            if(mail.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this@MainActivity, "Fields are empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            firebaseAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener{
                if(it.isSuccessful){
                    val intent = Intent(this@MainActivity,LogInActivity::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this@MainActivity, "Invalid mail or password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}