package com.example.lab_05_jetpackpaging_cloudservice.tools

import android.content.Context
import android.util.Log
import com.example.lab_05_jetpackpaging_cloudservice.util.model.MainViewModel
import com.example.lab_05_jetpackpaging_cloudservice.util.model.SensorLog
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader

class FillDatabase {
    companion object {
        fun readAndParseFile(context: Context, viewModel: MainViewModel, filename: String) {
            val sensorData = mutableListOf<SensorLog>()

            try {
                val inputStream = context.assets.open(filename)
                val reader = BufferedReader(InputStreamReader(inputStream))
                val jsonString = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    jsonString.append(line)
                }

                val jsonArray = JSONArray(jsonString.toString())

                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)

                    val date = jsonObject.getString("date")
                    val time = jsonObject.getString("time")
                    val comment = jsonObject.getString("comment")
                    val value = jsonObject.getDouble("value")

                    val sensorLog = SensorLog(date, time, comment, value)
//                    sensorData.add(sensorLog)
                    viewModel.create(sensorLog)
                }

//                Log.d("El data set recuperado es: ", sensorData.toString())

                reader.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
