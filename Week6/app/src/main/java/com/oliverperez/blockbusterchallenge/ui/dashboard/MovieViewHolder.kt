package com.oliverperez.blockbusterchallenge.ui.dashboard

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oliverperez.blockbusterchallenge.R
import com.oliverperez.blockbusterchallenge.model.Movie

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var poster = itemView.findViewById<ImageView>(R.id.poster_image)
    private var movieTitle = itemView.findViewById<TextView>(R.id.movie_title)

    fun bind(movie: Movie) {
        poster.setImageResource(movie.poster)
        movieTitle.text = movie.title
    }
}