package com.oliverperez.blockbusterchallenge.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.oliverperez.blockbusterchallenge.model.Movie
import com.oliverperez.blockbusterchallenge.R
import com.oliverperez.blockbusterchallenge.ui.dashboard.MovieDashboardActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        movie = intent.getParcelableExtra(MovieDashboardActivity.INTENT_MOVIE_KEY) as Movie
        title = movie.title
        poster.setImageResource(movie.poster)
        movieDetailTitle.text = movie.title
        releaseDateText.text = movie.releaseDate
        summaryTextView.text = movie.summary
    }
}