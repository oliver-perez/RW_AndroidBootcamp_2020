package com.oliverperez.blockbusterchallenge.Views

import android.media.Image
import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oliverperez.blockbusterchallenge.R
import kotlinx.android.synthetic.main.movie_view_holder.view.*

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
   var poster = itemView.findViewById<ImageView>(R.id.poster_image)!!
    var movieTitle = itemView.findViewById<TextView>(R.id.movie_title)!!
}