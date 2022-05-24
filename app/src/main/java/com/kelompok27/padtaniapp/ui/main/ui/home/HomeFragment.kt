package com.kelompok27.padtaniapp.ui.main.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.databinding.FragmentHomeBinding
import com.kelompok27.padtaniapp.ui.helper.SectionsPagerAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.inpari,
            R.string.inpago,
            R.string.Hipa,
            R.string.Inpara
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}


