package com.kelompok27.padtaniapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.databinding.ActivityLoginBinding
import com.kelompok27.padtaniapp.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var customToolbar: Toolbar
    private lateinit var textToolbar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customToolbar= findViewById(R.id.toolbar)
        textToolbar = findViewById(R.id.toolbarTitle)

        setSupportActionBar(customToolbar)
        textToolbar.text = "Sign in"

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