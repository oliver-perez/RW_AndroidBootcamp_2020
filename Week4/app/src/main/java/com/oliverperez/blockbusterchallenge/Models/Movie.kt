package com.oliverperez.blockbusterchallenge.Models

import java.util.*

data class Movie (
    val id: Int,
    val releaseDate: String,
    val title: String,
    val summary: String,
    val poster: Int
)