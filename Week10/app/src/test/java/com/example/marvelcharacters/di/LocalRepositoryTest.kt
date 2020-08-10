package com.example.marvelcharacters.di

import android.app.Application
import com.example.marvelcharacters.repository.local.CharacterDao
import com.example.marvelcharacters.repository.local.CharacterRepository
import com.example.marvelcharacters.repository.local.RoomRepository
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class LocalRepositoryTest : KoinTest {
    @Mock
    private lateinit var appMock: Application
    private val characterRepository: CharacterRepository by inject<RoomRepository>()
    private val characterDao: CharacterDao by inject()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        startKoin {
            androidContext(appMock)
            modules(localRepositoryModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `Test Character Room Repository Created`() {
        assertNotNull(characterRepository)
    }

    @Test
    fun `Test Character DAO Created`() {
        assertNotNull(characterDao)
    }
}