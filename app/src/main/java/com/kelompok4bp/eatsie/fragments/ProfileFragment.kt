package com.kelompok4bp.eatsie.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import com.kelompok4bp.eatsie.LoginActivity
import com.kelompok4bp.eatsie.R

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val btnEdit = view.findViewById<AppCompatButton>(R.id.btnEdit)
        val btnLogout = view.findViewById<AppCompatButton>(R.id.btnLogout)

        btnEdit.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("status", "edit")

            findNavController().navigate(R.id.formProfileFragment, bundle)
        }

        btnLogout.setOnClickListener {
            activity?.let{
                val intent = Intent (it, LoginActivity::class.java)
                it.startActivity(intent)
            }
        }

        return view
    }
}