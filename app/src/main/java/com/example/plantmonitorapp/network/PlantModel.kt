package com.example.plantmonitorapp.network

import com.squareup.moshi.Json

data class PlantModel(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val sensorId: Int? = null,
    val alertLevel: Int = 0,
    val isAlertEnabled: Boolean = false
)