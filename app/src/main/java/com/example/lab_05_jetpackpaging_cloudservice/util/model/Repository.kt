package com.example.lab_05_jetpackpaging_cloudservice.util.model

import kotlinx.coroutines.delay

/* (3) */
class Repository {
    private val remoteDataSource = (1..100).map {
        SensorLog(
            date = "Date $it",
            time = "Time $it",
            comment = "Comment   $it",
            value = it
        )
    }
    /* FOR: Test empty list */
    // private val remoteDataSource = emptyList<SensorLog>()

    suspend fun getItems(page: Int, pageSize: Int): Result<List<SensorLog>> {
        delay(2000L)
        val startingIndex = page * pageSize
        return if (startingIndex + pageSize <= remoteDataSource.size) {
            Result.success(
                remoteDataSource.slice(startingIndex until startingIndex + pageSize)
            )
        } else Result.success(emptyList())
    }
}