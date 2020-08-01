package com.example.marvelcharacters.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.WorkInfo
import com.example.marvelcharacters.R
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import java.util.*

class CharacterViewModelTests {

    private lateinit var sut: CharacterViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        sut = CharacterViewModel()
    }

    @Test
    fun test_workerConstraintsRequiredNetworkType_isNotRoaming() {
        // Given
        val expectedNetworkType = NetworkType.NOT_ROAMING
        // When
        val actualNetworkType = sut.getWorkerConstraints().requiredNetworkType
        // Then
        assertEquals(expectedNetworkType, actualNetworkType)
    }

    @Test
    fun test_workerConstraintsRequiresBatteryNotLow_isTrue() {
        // Given
        val expectedValue = true
        // When
        val actualValue = sut.getWorkerConstraints().requiresBatteryNotLow()
        // Then
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun test_workerConstraintsRequiresStorageNotLow_isTrue() {
        // Given
        val expectedValue = true
        // When
        val actualValue = sut.getWorkerConstraints().requiresStorageNotLow()
        // Then
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun test_workerPostBatchStatusWhenStateIsENQUEUED_isSyncInProgress() {
        // Given
        val expectedValue = R.string.sync_in_progress
        val dummyWorkInfo = WorkInfo(
            UUID.randomUUID(), WorkInfo.State.ENQUEUED, Data.EMPTY, listOf(""),
            Data.EMPTY, 0
        )
        // When
        sut.postBatchCharactersStatusWhenEnqueued(dummyWorkInfo)
        // Then
        sut.getUpdateBatchStatus().observeForever(androidx.lifecycle.Observer { actualValue ->
            assertEquals(expectedValue, actualValue)
        })
    }

}