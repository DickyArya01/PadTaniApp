package com.kelompok27.padtaniapp.ui.main.ui.home.bibit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kelompok27.padtaniapp.R


class InpagoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inpago, container, false)
    }

    companion object {
        private const val ARG_COUNT = "Inpago"
        fun newInstance(counter: Int?): InpagoFragment {
            val fragment = InpagoFragment()
            val args = Bundle()
            args.putInt(ARG_COUNT, counter!!)
            fragment.arguments = args
            return fragment
        }
    }
}