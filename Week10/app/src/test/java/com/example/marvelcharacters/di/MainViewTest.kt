package com.example.marvelcharacters.di

import com.example.marvelcharacters.view.CharacterGridAdapter
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class MainViewTest : KoinTest {

    private val characterGridAdapter: CharacterGridAdapter by inject()

    @Before
    fun setup() {
        startKoin {
            modules(mainViewModule)
        }
    }

    @Test
    fun `Test Character Grid Adapter Created`() {
        Assert.assertNotNull(characterGridAdapter)
    }
}