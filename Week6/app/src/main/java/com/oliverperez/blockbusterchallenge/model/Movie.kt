package com.oliverperez.blockbusterchallenge.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
* Data class to represent a Movie item abstraction
*
* @property id The unique ID of the movie
* @property releaseDate The date in which the film was released
* @property title The title of the movie
* @property summary The summary of the movie
* @property poster The poster image of the movie
 */
@Parcelize
@Entity(tableName = "movie_table")
data class Movie(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                 val releaseDate: String,
                 val title: String,
                 val summary: String,
                 val poster: Int) : Parcelable
