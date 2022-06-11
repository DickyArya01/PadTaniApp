package com.kelompok27.padtaniapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.databinding.ActivityMainBinding
import com.kelompok27.padtaniapp.ui.login.LoginActivity
import com.kelompok27.padtaniapp.ui.main.ui.calculate.CalculateFragment
import com.kelompok27.padtaniapp.ui.main.ui.explore.ExploreFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.HomeFragment
import com.kelompok27.padtaniapp.ui.main.ui.location.LocationFragment
import com.kelompok27.padtaniapp.ui.main.ui.profile.ProfileFragment
import com.kelompok27.padtaniapp.ui.splashscreen.SplashCamera

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val homeFragment = HomeFragment()
    private val calculateFragment = CalculateFragment()
    private val locationFragment = LocationFragment()
    private val exploreFragment = ExploreFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
           Intent(this@MainActivity, SplashCamera::class.java).also {
               startActivity(it)
           }
        }

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        makeCurrentFragment(homeFragment)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.imHome -> {
                    makeCurrentFragment(homeFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.imCalcul -> {
                    makeCurrentFragment(calculateFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.imloc -> {
                    makeCurrentFragment(locationFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.imexplore -> {
                    makeCurrentFragment(exploreFragment)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frag_nav, fragment)
            commit()
        }
    }
}