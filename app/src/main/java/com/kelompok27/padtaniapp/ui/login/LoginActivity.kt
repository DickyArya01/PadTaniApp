package com.kelompok27.padtaniapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok27.padtaniapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}