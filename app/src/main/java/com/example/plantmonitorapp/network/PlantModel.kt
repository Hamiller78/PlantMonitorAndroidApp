package com.example.plantmonitorapp.network

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

data class PlantModel (
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val sensorId: Int? = null,
    val alertLevel: Int = 0,
    val isAlertEnabled: Boolean = false,
    // Properties not from the REST API, but set during runtime
    // I guess this class isn't a model then, but a viewmodel?
    var sensorModel: SensorModel? = null,
    //@Bindable
    var sensorValue: String = "0.000"
)