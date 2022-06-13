package com.kelompok27.padtaniapp.ui.main.ui.home.bibit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kelompok27.padtaniapp.R

class InparaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inpara, container, false)
    }

    companion object {
        private const val ARG_COUNT = "Inpara"
        fun newInstance(counter: Int?): InparaFragment {
            val fragment = InparaFragment()
            val args = Bundle()
            args.putInt(ARG_COUNT, counter!!)
            fragment.arguments = args
            return fragment
        }
    }
}