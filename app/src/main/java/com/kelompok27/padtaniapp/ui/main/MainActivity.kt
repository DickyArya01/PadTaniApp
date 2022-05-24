package com.kelompok27.padtaniapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kelompok27.padtaniapp.R
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
            val navView: BottomNavigationView = bottomNavigationView
        }

        val navController = findNavController(R.id.nav_host_fragment_container)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment
            )
        )


    }
}