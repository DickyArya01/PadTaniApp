package com.kelompok27.padtaniapp.ui.main

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import android.view.Surface
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.databinding.ActivityCameraBinding
import java.io.File

class CameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClose.setOnClickListener {
            Intent(this@CameraActivity, MainActivity::class.java).also {
                startActivity(it)
            }
        }


        binding.btnCapture.setOnClickListener { takePhoto() }

        binding.btnFolder.setOnClickListener { openGallery() }

        binding.btnClose.setOnClickListener { closeCameraActivity() }
    }

    private fun closeCameraActivity() {
        Intent(this@CameraActivity, MainActivity::class.java).also {
            startActivity(it)
        }
    }

    public override fun onResume() {
        super.onResume()
        hideSystemUI()
        startCamera()
    }

    private fun takePhoto() {
        Intent(this@CameraActivity, DetailActivity::class.java).also {
            startActivity(it)
        }
    }

    private fun openGallery() {
        Toast.makeText(
            this@CameraActivity,
            "Yee buka gallery",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun startCamera() {

    }

    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

}