package com.kelompok4bp.eatsie.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.kelompok4bp.eatsie.R

class FormProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_form_profile, container, false)

        val btnBack = view.findViewById<ImageView>(R.id.ivIconBackToProfile)

        btnBack.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("status", "tambah")

            findNavController().navigate(R.id.profileFragment, bundle)
        }

        return view
    }
}