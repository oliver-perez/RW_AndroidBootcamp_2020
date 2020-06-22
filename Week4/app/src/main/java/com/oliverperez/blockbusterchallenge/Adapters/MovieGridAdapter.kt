package com.oliverperez.blockbusterchallenge.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oliverperez.blockbusterchallenge.DataManagers.MovieDataManager
import com.oliverperez.blockbusterchallenge.Models.Movie
import com.oliverperez.blockbusterchallenge.R
import com.oliverperez.blockbusterchallenge.Views.MovieViewHolder

class MovieGridAdapter(private val movies: Set<Movie>): RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_view_holder, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        holder.poster = movies.toList()[position].poster
    }
}