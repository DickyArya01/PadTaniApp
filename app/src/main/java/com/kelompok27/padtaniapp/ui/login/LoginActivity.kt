package com.kelompok27.padtaniapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok27.padtaniapp.databinding.ActivityLoginBinding
import com.kelompok27.padtaniapp.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            intentToMain()
        }
    }

    private fun intentToMain(){
        Intent(this@LoginActivity, MainActivity::class.java).also {
            startActivity(it)
        }
    }
}