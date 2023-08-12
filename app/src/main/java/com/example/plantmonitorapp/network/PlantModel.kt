package com.example.plantmonitorapp.network

import com.squareup.moshi.Json

data class PlantModel(
    @Json(name = "Id") val id: String,
    @Json(name = "Name") val name: String,
    @Json(name = "Description") val description: String,
    @Json(name = "ImageUrl") val imageUrl: String,
    @Json(name = "SensorId") val sensorId: Int? = null,
    @Json(name = "AlertLevel") val alertLevel: Int = 0,
    @Json(name = "IsAlertEnabled") val isAlertEnabled: Boolean = false
)