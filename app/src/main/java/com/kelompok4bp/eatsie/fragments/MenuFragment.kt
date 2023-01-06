package com.kelompok4bp.eatsie.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kelompok4bp.eatsie.Menu
import com.kelompok4bp.eatsie.R
import com.kelompok4bp.eatsie.adapter.MyAdapter

class MenuFragment : Fragment() {
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var menuArrayList: ArrayList<Menu>

    lateinit var imageFood : Array<Int>
    lateinit var textFood : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val btnBack = view.findViewById<ImageView>(R.id.ivIconBackToHome)

        btnBack.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("status", "tambah")

            findNavController().navigate(R.id.homeFragment, bundle)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvMenu)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(menuArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        menuArrayList = arrayListOf<Menu>()

        imageFood = arrayOf(
            R.drawable.sate,
            R.drawable.rendang,
            R.drawable.soto,
            R.drawable.pempek
        )

        textFood = arrayOf(
            getString(R.string.sate),
            getString(R.string.rendang),
            getString(R.string.soto_madura),
            getString(R.string.pempek)
        )

        for (i in imageFood.indices) {
            val foodMenu = Menu(imageFood[i], textFood[i])
            menuArrayList.add(foodMenu)
        }
    }
}