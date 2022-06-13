package com.kelompok27.padtaniapp.ui.main.ui.home


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.kelompok27.padtaniapp.R
import com.kelompok27.padtaniapp.adapter.ViewPagerAdapter
import com.kelompok27.padtaniapp.databinding.FragmentHomeBinding
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.HipaFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.InpagoFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.InparaFragment
import com.kelompok27.padtaniapp.ui.main.ui.home.bibit.InpariFragment


@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

//        val viewPager2: ViewPager2 = binding.viewPager

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
                    3 -> view.text = "Ipara"
                }
            }.attach()
        }
    }

}


