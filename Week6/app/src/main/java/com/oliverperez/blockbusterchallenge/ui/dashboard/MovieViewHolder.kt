package com.oliverperez.blockbusterchallenge.ui.dashboard

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oliverperez.blockbusterchallenge.R

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var poster = itemView.findViewById<ImageView>(R.id.poster_image)!!
    var movieTitle = itemView.findViewById<TextView>(R.id.movie_title)!!
}