package com.example.lab_05_jetpackpaging_cloudservice.aws

import android.util.Log
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.SensorData

class ApiDataStore {

    fun createSensorData(value: Double,  date: String, time: String, comment: String) {
        val item:SensorData = SensorData.builder()
            .value(value)
            .date(date)
            .time(time)
            .comment(comment)
            .build()

        Amplify.API.mutate(
            ModelMutation.create(item),
            { Log.i("MyAmplifyApp", "Todo with id: ${item.id}") },
            { Log.e("MyAmplifyApp", "Create failed") }
        )
    }

    fun readPagingSensorData() {

    }


}