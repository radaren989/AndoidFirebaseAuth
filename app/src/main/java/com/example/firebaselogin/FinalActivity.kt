package com.example.firebaselogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaselogin.databinding.ActivityFinalBinding

class FinalActivity: AppCompatActivity() {
    lateinit var binding: ActivityFinalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}