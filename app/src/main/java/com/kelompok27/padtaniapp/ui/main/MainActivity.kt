package com.kelompok27.padtaniapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok27.padtaniapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            bottomNavigationView.background = null
            bottomNavigationView.menu.getItem(2).isEnabled = false
        }

    }
}