package com.oliverperez.blockbusterchallenge.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oliverperez.blockbusterchallenge.model.Movie
import com.oliverperez.blockbusterchallenge.R

class MovieGridAdapter(private val movies: List<Movie>, private val clickListener: MovieClickListener): RecyclerView.Adapter<MovieViewHolder>() {
    interface MovieClickListener {
        fun movieItemClicked(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_view_holder, parent, false)
        return MovieViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.poster.setImageResource(movies[position].poster)
        holder.movieTitle.text = movies[position].title
        holder.itemView.setOnClickListener {
            clickListener.movieItemClicked(movies[position])
        }
    }
}