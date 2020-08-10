package com.example.marvelcharacters.di

import com.example.marvelcharacters.viewmodel.CharacterViewModel
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class ViewModelModuleTest : KoinTest {

    private val viewModel: CharacterViewModel by inject()

    @Before
    fun setup() {
        startKoin {
            modules(viewModelModule)
        }
    }

    @Test
    fun `Test View Model Module Created`() {
        assertNotNull(viewModel)
    }
}