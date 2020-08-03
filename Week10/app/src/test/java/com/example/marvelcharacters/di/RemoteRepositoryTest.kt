@file:Suppress("DEPRECATION")

package com.example.marvelcharacters.di

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import com.example.marvelcharacters.repository.remote.RemoteApi
import com.example.marvelcharacters.repository.remote.RemoteDataSource
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import org.mockito.MockitoAnnotations

class RemoteRepositoryTest : KoinTest {
    private val remoteDataSource: RemoteDataSource by inject()
    private val baseUrl: String by lazy { get(named("BASE_URL")) as String }
    private val periodicWorkRequestConstraints: Constraints by inject()
    private val api: RemoteApi by inject()
    private val okHttpClient: OkHttpClient by inject()
    private val periodicApiWorker: PeriodicWorkRequest by inject()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        startKoin {
            modules(remoteRepositoryModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `Test Remote Data Source Created`() {
        assertNotNull(remoteDataSource)
    }

    @Test
    fun `Test Correct Base URL`() {
        assertEquals("https://gateway.marvel.com", baseUrl)
    }

    @Test
    fun `Test Periodic Work Request Constraints`() {
        assertNotNull(periodicWorkRequestConstraints)
    }

    @Test
    fun `Test Periodic Work Request Constraints Required NetworkType is NotRoaming`() {
        // Given
        val expectedNetworkType = NetworkType.NOT_ROAMING
        // When
        val actualNetworkType = periodicWorkRequestConstraints.requiredNetworkType
        // Then
        assertEquals(expectedNetworkType, actualNetworkType)
    }

    @Test
    fun `Test Periodic Work Request Constraints Requires Battery Not Low`() {
        // Given
        val expectedValue = true
        // When
        val actualValue = periodicWorkRequestConstraints.requiresBatteryNotLow()
        // Then
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `Test Periodic Work Request Constraints Requires Storage Not Low`() {
        // Given
        val expectedValue = true
        // When
        val actualValue = periodicWorkRequestConstraints.requiresStorageNotLow()
        // Then
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `Test API Created`() {
        assertNotNull(api)
    }

    @Test
    fun `Test OKHttp`() {
        assertNotNull(okHttpClient)
        Assert.assertTrue(okHttpClient.connectTimeoutMillis == 30000)
        Assert.assertTrue(okHttpClient.writeTimeoutMillis == 30000)
        Assert.assertTrue(okHttpClient.readTimeoutMillis == 30000)
    }

    @Test
    fun `Test Periodic Work Request Created`() {
        assertNotNull(periodicApiWorker)
    }

}