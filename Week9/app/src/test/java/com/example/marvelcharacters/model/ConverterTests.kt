package com.example.marvelcharacters.model

import com.example.marvelcharacters.model.converters.Converter
import com.example.marvelcharacters.model.entities.Thumbnail
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ConverterTests {

    private lateinit var sut: Converter

    @Before
    fun setup() {
        sut = Converter()
    }

    @Test
    fun test_conversionFromUrlToThumbnailObject_isCorrect() {
        // Given
        val dummyUrl = "www.dummyUrl.com/image.png"
        val expectedThumbnail = Thumbnail(dummyUrl, "")
        // When
        val actualThumbnail = sut.fromThumbnailUrl(dummyUrl)
        // Then
        assertEquals(expectedThumbnail, actualThumbnail)
    }

    @Test
    fun test_conversionFromToThumbnailObjectToUrl_isCorrect() {
        // Given
        val dummyThumbnail = Thumbnail("www.dummyUrl.com/image", "png")
        val expectedUrl = "www.dummyUrl.com/image.png"
        // When
        val actualThumbnail = sut.thumbnailToURL(dummyThumbnail)
        // Then
        assertEquals(expectedUrl, actualThumbnail)
    }
}