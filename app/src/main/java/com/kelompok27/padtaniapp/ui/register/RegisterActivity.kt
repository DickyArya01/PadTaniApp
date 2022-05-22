package com.kelompok27.padtaniapp.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.databinding.ActivityRegisterBinding
import com.kelompok27.padtaniapp.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var customToolbar: Toolbar
    private lateinit var textToolbar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customToolbar("Sign up")

        binding.tvLogin.setOnClickListener {
            intentToLogin()
        }
    }

    private fun intentToLogin(){
        Intent(this@RegisterActivity, LoginActivity::class.java).also {
            startActivity(it)
        }
    }

    private fun customToolbar(desc: String){
        customToolbar= findViewById(R.id.toolbar)
        textToolbar = findViewById(R.id.toolbarTitle)

        setSupportActionBar(customToolbar)
        textToolbar.text = "$desc"
    }

}