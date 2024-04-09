package com.example.georescuehub

import android.content.ClipData
import android.content.Context
import android.media.RouteListingPreference
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdpter(private val context: Context, private val items: List<Item>) :
RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_call_logs, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = items[position]
        holder.nameView.text = currentItem.name
        holder.phoneView.text = currentItem.phoneNo.toString()
        holder.imageView.setImageResource(currentItem.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

