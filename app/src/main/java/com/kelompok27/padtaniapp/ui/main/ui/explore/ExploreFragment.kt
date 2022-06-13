package com.kelompok27.padtaniapp.ui.main.ui.explore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.adapter.ViewPagerAdapter
import com.kelompok27.padtaniapp.api.Api
import com.kelompok27.padtaniapp.databinding.FragmentExploreBinding
import com.kelompok27.padtaniapp.databinding.FragmentHomeBinding
import com.kelompok27.padtaniapp.helper.Constant
import com.kelompok27.padtaniapp.model.BibitResponse
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.HipaFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.InpagoFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.InparaFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.InpariFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExploreFragment : Fragment(R.layout.fragment_explore) {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentExploreBinding.bind(view)

        val fragment: ArrayList<Fragment> = arrayListOf(
            HipaFragment(),
            InpagoFragment(),
            InparaFragment(),
            InpariFragment()
        )

        val adapter = ViewPagerAdapter(fragment, this )



        with(binding){
            viewPager.adapter = adapter

            TabLayoutMediator(tabs, viewPager) {view, position ->
                when(position){
                    0 -> view.text = "Hipa"
                    1 -> view.text = "Inpago"
                    2 -> view.text = "Inpari"
                    3 -> view.text = "Inpara"
                }
            }.attach()
        }

    }


    
    
    
}