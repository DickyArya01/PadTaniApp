package com.kelompok27.padtaniapp.ui.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok27.padtaniapp.databinding.ActivitySplashscreenBinding
import com.kelompok27.padtaniapp.ui.login.LoginActivity
import com.kelompok27.padtaniapp.ui.register.RegisterActivity

@SuppressLint("CustomSplashScreen")
class SplashscreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivLogo.alpha = 0f
        binding.ivLogo.animate().setDuration(4000).alpha(1f).withEndAction{
            val intentToMain = Intent(this@SplashscreenActivity, LoginActivity::class.java)
            startActivity(intentToMain)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

    }
}