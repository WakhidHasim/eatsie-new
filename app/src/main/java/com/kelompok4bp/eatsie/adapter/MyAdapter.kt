package com.kelompok4bp.eatsie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.kelompok4bp.eatsie.Menu
import com.kelompok4bp.eatsie.R

class MyAdapter(private val menuList : ArrayList<Menu>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = menuList[position]
        holder.foodImage.setImageResource(currentItem.foodImage)
        holder.foodName.text = currentItem.foodName
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage : ShapeableImageView = itemView.findViewById(R.id.ivFood)
        val foodName : TextView = itemView.findViewById(R.id.tvFood)
    }
}