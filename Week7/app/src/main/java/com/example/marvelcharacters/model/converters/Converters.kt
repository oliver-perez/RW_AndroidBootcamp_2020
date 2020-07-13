package com.example.marvelcharacters.model.converters

import androidx.room.TypeConverter
import com.example.marvelcharacters.model.entities.Thumbnail

class Converters {
    @TypeConverter
    fun fromThumbnailUrl(url: String): Thumbnail = Thumbnail(url, "")

    @TypeConverter
    fun thumbnailToURL(thumbnail: Thumbnail): String = thumbnail.path + "." + thumbnail.extension
}