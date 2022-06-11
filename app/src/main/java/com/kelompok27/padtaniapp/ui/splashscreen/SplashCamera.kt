package com.kelompok27.padtaniapp.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.camera
import com.kelompok27.padtaniapp.databinding.ActivitySplashCameraBinding
import com.kelompok27.padtaniapp.ui.login.LoginActivity

class SplashCamera : AppCompatActivity() {
    private lateinit var binding: ActivitySplashCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.animationView.alpha = 1f
        binding.animationView.animate().setDuration(2000).alpha(1f).withEndAction{
            val intentToMain = Intent(this, camera::class.java)
            startActivity(intentToMain)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

    }
}