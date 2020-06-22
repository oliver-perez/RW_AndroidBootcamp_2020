package com.oliverperez.blockbusterchallenge.DataManagers

import com.oliverperez.blockbusterchallenge.Models.Movie
import com.oliverperez.blockbusterchallenge.R

class MovieDataManager {
    private val movies = setOf<Movie>(
        Movie(id = 1,
            releaseDate = "01/02/2020",
            summary = "Awesome Movie",
            title = "Back to the future",
            poster = R.drawable.back_to_the_future),
        Movie(id = 2,
            releaseDate = "01/02/2020",
            summary = "Awesome Movie",
            title = "Donnie Darko",
            poster = R.drawable.donnie_darko),
        Movie(id = 3,
            releaseDate = "01/02/2020",
            summary = "Awesome Movie",
            title = "Leon",
            poster = R.drawable.leon),
        Movie(id = 4,
            releaseDate = "01/02/2020",
            summary = "Awesome Movie",
            title = "Man on fire",
            poster = R.drawable.man_on_fire),
        Movie(id = 5,
            releaseDate = "01/02/2020",
            summary = "Awesome Movie",
            title = "Matrix",
            poster = R.drawable.matrix),
        Movie(id = 6,
            releaseDate = "01/02/2020",
            summary = "Awesome Movie",
            title = "Raiders of the lost arc",
            poster = R.drawable.raiders_of_the_lost_arc),
        Movie(id = 7,
            releaseDate = "20 July 2001",
            summary = "Chihiro and her parents are moving to a small Japanese town in the countryside, " +
                    "much to Chihiro's dismay. On the way to their new home, Chihiro's father makes a " +
                    "wrong turn and drives down a lonely one-lane road which dead-ends in front of a tunnel.",
            title = "Spirited Away",
            poster = R.drawable.spirited_away),
        Movie(id = 8,
            releaseDate = "01/02/2020",
            summary = "Awesome Movie",
            title = "The Shawshank Redemption",
            poster = R.drawable.the_shawshank_redemption)
    )

    fun getMovies(): Set<Movie> {
        return movies
    }
}