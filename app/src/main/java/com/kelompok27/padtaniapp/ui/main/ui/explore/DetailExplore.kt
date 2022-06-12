package com.kelompok27.padtaniapp.ui.main.ui.explore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok27.padtaniapp.databinding.ActivityDetailExploreBinding

class DetailExplore : AppCompatActivity() {
    private lateinit var binding: ActivityDetailExploreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailExploreBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}