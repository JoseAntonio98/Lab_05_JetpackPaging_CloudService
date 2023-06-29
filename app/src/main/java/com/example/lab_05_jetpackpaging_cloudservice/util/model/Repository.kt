package com.example.lab_05_jetpackpaging_cloudservice.util.model

import android.util.Log
import com.amplifyframework.api.graphql.GraphQLRequest
import com.amplifyframework.api.graphql.PaginatedResult
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.api.graphql.model.ModelPagination
import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.SensorData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/* (3) */
class Repository {

    suspend fun getItems(page: Int, pageSize: Int): Result<List<SensorData>> {
        Log.i("Pagina #", page.toString())

        return Result.success(
            queryFirstPage(pageSize)
        )
    }

    suspend fun queryFirstPage(pageSize: Int): List<SensorData> {
        return withContext(Dispatchers.IO) {
            suspendCoroutine { continuation ->
                var resumed = false

                query(
                    ModelQuery.list(SensorData::class.java, ModelPagination.limit(pageSize)),
                    onSuccess = { items ->
                        if (!resumed) {
                            resumed = true
                            continuation.resume(items)
                        }
                    },
                    onFailure = { error ->
                        if (!resumed) {
                            resumed = true
                            continuation.resumeWithException(error)
                        }
                    }
                )
            }
        }
    }

    fun query(
        request: GraphQLRequest<PaginatedResult<SensorData>>,
        onSuccess: (List<SensorData>) -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        Amplify.API.query(
            request,
            { response ->
                if (response.hasData()) {

                    onSuccess(response.data.items as List<SensorData>)

                    if (response.data.hasNextResult()) {
                        query(response.data.requestForNextResult, onSuccess, onFailure)
                    }
                }
            },
            { error ->
                onFailure(error)
            }
        )
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
            { Log.i("MyAmplifyApp", "SensorData with id: ${item.id}") },
            { Log.e("MyAmplifyApp", "Create failed") }
        )
    }
}