package com.example.lab_05_jetpackpaging_cloudservice.util.model

import android.util.Log
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.SensorData
import kotlinx.coroutines.delay

/* (3) */
class Repository {
    private val remoteDataSource = (1..100).map {
        SensorLog(
            date = "Date $it",
            time = "Time $it",
            comment = "Comment   $it",
            value = it.toDouble()
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

    fun create(sensorLog: SensorLog) {
        val item:SensorData = SensorData.builder()
            .value(sensorLog.value)
            .date(sensorLog.date)
            .time(sensorLog.time)
            .comment(sensorLog.comment)
            .build()

        Amplify.API.mutate(
            ModelMutation.create(item),
            { Log.i("MyAmplifyApp", "Todo with id: ${item.id}") },
            { Log.e("MyAmplifyApp", "Create failed") }
        )
    }
}