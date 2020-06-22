package com.oliverperez.blockbusterchallenge.Models

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Movie(val id: Int,
                 val releaseDate: String,
                 val title: String,
                 val summary: String,
                 val poster: Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()!!
    )

    companion object CREATOR: Parcelable.Creator<Movie> {
        override fun createFromParcel(source: Parcel): Movie = Movie(source)

        override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)

    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(releaseDate)
        dest.writeString(title)
        dest.writeString(summary)
        dest.writeInt(poster)
    }

    override fun describeContents() = 0
}
