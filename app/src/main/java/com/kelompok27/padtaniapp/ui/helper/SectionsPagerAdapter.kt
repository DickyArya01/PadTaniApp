package com.kelompok27.padtaniapp.ui.helper

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kelompok27.padtaniapp.ui.main.ui.home.HomeFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.*

class SectionsPagerAdapter(activity: HomeFragment) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = InpariFragment()
            1 -> fragment = InpagoFragment()
            2 -> fragment = HipaFragment()
            3 -> fragment = InparaFragment()
        }
        return fragment as Fragment
    }

}