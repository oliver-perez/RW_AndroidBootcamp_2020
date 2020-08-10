package com.example.marvelcharacters.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Thumbnail (
    val path: String,
    val extension: String
) : Parcelable
