package com.kelompok4bp.eatsie.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.kelompok4bp.eatsie.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val cardMenuNusantara = view.findViewById<CardView>(R.id.cardMenuNusantara)

        cardMenuNusantara.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("status", "open")

            findNavController().navigate(R.id.menuFragment, bundle)
        }

        return view
    }
}