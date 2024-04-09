package com.example.georescuehub

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var imageView: ImageView
    var nameView: TextView
    var phoneView: TextView

    init {
        imageView = itemView.findViewById(R.id.imageIC)
        nameView = itemView.findViewById(R.id.categoryTv)
        phoneView = itemView.findViewById(R.id.phoneEt)
    }
}
