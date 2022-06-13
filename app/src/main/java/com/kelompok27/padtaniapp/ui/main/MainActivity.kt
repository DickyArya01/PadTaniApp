package com.kelompok27.padtaniapp.ui.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.adapter.ViewPagerAdapter
import com.kelompok27.padtaniapp.databinding.ActivityMainBinding
import com.kelompok27.padtaniapp.ui.login.LoginActivity
import com.kelompok27.padtaniapp.ui.main.ui.calculate.CalculateFragment
import com.kelompok27.padtaniapp.ui.main.ui.explore.ExploreFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.HomeFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.HipaFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.InpagoFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.InparaFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.InpariFragment
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

        if (!allPermissionGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRE_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }

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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionGranted()) {
                Toast.makeText(
                    this, "Permission not granted", Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    private fun allPermissionGranted() = REQUIRE_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    companion object {
        const val CAMERA_X_RESULT = 200

        private val REQUIRE_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
}