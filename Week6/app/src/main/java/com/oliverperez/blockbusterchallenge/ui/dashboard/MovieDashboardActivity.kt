package com.oliverperez.blockbusterchallenge.ui.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliverperez.blockbusterchallenge.ui.login.LoginActivity
import com.oliverperez.blockbusterchallenge.ui.detail.MovieDetailActivity
import com.oliverperez.blockbusterchallenge.model.LoginPrefs
import com.oliverperez.blockbusterchallenge.model.DummyDataProvider
import com.oliverperez.blockbusterchallenge.model.Movie
import com.oliverperez.blockbusterchallenge.R
import com.oliverperez.blockbusterchallenge.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MovieDashboardActivity : AppCompatActivity(), MovieGridAdapter.MovieClickListener {

    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var moviesRecyclerView: RecyclerView
    private val movieAdapter by lazy { MovieGridAdapter(emptyList(), this)  }

    companion object {
        const val INTENT_MOVIE_KEY = "movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesRecyclerView = movies_recycler_view
        moviesRecyclerView.layoutManager = GridLayoutManager(this, 2)
        moviesRecyclerView.adapter = movieAdapter

        if (!LoginPrefs.isUserLoggedIn()) {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        moviesViewModel.getAllMovies().observe(this, Observer { movies ->
            movieAdapter.updateMovies(movies)
        })
    }

    override fun movieItemClicked(movie: Movie) {
        Intent(this, MovieDetailActivity::class.java)
            .apply { putExtra(INTENT_MOVIE_KEY, movie) }
            .run { startActivity(this) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_item) {
            LoginPrefs.saveUserLoginStatus(false)
            Toast.makeText(this, R.string.you_logged_out, Toast.LENGTH_LONG).show()
            showLogInScreen()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showLogInScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}