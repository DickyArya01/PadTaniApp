package com.kelompok27.padtaniapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kelompok27.padtaniapp.R


class ViewPagerAdapter( val items: ArrayList<Fragment>, fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int  = items.size

    override fun createFragment(position: Int): Fragment = items[position]


}