package com.example.marvelcharacters.di

import android.app.Application
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class ModuleTest : KoinTest {

    @Mock
    private lateinit var appMock: Application

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `Test Koin Modules`() {
        startKoin {
            androidContext(appMock)
            modules(
                listOf(
                    localRepositoryModule,
                    mainViewModule,
                    remoteRepositoryModule,
                    viewModelModule
                )
            )
        }.checkModules()
        stopKoin()
    }

}