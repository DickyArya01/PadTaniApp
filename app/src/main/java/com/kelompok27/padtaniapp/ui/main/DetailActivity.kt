package com.kelompok27.padtaniapp.ui.main

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok27.padtaniapp.databinding.ActivityDetailBinding
import com.kelompok27.padtaniapp.helper.Constant

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uriPhoto = intent.getStringExtra(Constant.TAGUri)

        val getPhoto = Uri.parse(uriPhoto)

        binding.imgDetailResult.setImageURI(getPhoto)

    }


}