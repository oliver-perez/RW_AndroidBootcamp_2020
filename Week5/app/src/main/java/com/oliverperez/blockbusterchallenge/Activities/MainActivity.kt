package com.oliverperez.blockbusterchallenge.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliverperez.blockbusterchallenge.Adapters.MovieGridAdapter
import com.oliverperez.blockbusterchallenge.DataManagers.LoginPrefs
import com.oliverperez.blockbusterchallenge.DataManagers.MovieDataManager
import com.oliverperez.blockbusterchallenge.Models.Movie
import com.oliverperez.blockbusterchallenge.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieGridAdapter.MovieClickListener {

    private lateinit var moviesRecyclerView: RecyclerView
    private val dataManager = MovieDataManager()

    companion object {
        const val INTENT_MOVIE_KEY = "movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesRecyclerView = movies_recycler_view
        moviesRecyclerView.layoutManager = GridLayoutManager(this, 2)
        moviesRecyclerView.adapter = MovieGridAdapter(dataManager.getMovies(), this)
        if (!LoginPrefs.isUserLoggedIn()) {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun movieItemClicked(movie: Movie) {
        val movieItem = Intent(this, MovieDetailActivity::class.java)
        movieItem.putExtra(INTENT_MOVIE_KEY, movie)
        startActivity(movieItem)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        LoginPrefs.saveUserLoginStatus(false)
        Toast.makeText(this, "You logged out", Toast.LENGTH_LONG).show()
        showLogInScreen()
        return super.onOptionsItemSelected(item)
    }

    fun showLogInScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

}