package com.kelompok27.padtaniapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.databinding.ActivityMainBinding
import com.kelompok27.padtaniapp.ui.main.ui.calculate.CalculateFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.HomeFragment
import com.kelompok27.padtaniapp.ui.main.ui.location.LocationFragment
import com.kelompok27.padtaniapp.ui.main.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val homeFragment = HomeFragment()
    private val calculateFragment = CalculateFragment()
    private val locationFragment = LocationFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false


        makeCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.imHome -> makeCurrentFragment(homeFragment)
                R.id.imCalcul -> makeCurrentFragment(calculateFragment)
                R.id.imloc -> makeCurrentFragment(locationFragment)
                R.id.imProfile -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frag_nav, fragment)
            commit()
        }
    }
}