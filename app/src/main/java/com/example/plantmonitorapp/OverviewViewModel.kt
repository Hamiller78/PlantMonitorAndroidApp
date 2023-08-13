package com.example.plantmonitorapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantmonitorapp.network.PlantModel
import com.example.plantmonitorapp.network.PlantWatchApi
import com.example.plantmonitorapp.network.SensorModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    private val _plants = MutableLiveData<List<PlantModel>>()
    private val _sensors = MutableLiveData<List<SensorModel>>()
    val plants: LiveData<List<PlantModel>> = _plants

    /**
     * Call getPlants() on init so we can display status immediately.
     */
    init {
        getPlants()
    }

    private fun getPlants() {
        viewModelScope.launch {
            try {
                _plants.value = PlantWatchApi.retrofitService.getPlants()
                _sensors.value = PlantWatchApi.retrofitService.getSensors()
                updateSensorsRefsInPlants()
                while (true) {
                    var plantList = pollSensors()
                    _plants.postValue(plantList)
                    delay(1000L)
                }
            } catch (e: Exception) {
                _plants.value = listOf()
            }
        }
    }

    private fun updateSensorsRefsInPlants() {
        for (plant in _plants.value!!)
        {
            for (sensor in _sensors.value!!)
            {
                if (plant.sensorId == sensor.id)
                {
                    plant.sensorModel = sensor
                }
            }
        }
    }

    private suspend fun pollSensors() : List<PlantModel> {
        val plantList = mutableListOf<PlantModel>()
        for (plant in _plants?.value ?: emptyList()) {
            try {
                val newPlant = plant.copy()
                val sensorValue = PlantWatchApi.retrofitService.getSensorValue(plant.sensorModel!!.serviceUri)
                if (sensorValue.isSuccessful) {
                    val sensorNumber = sensorValue.body()!!.toFloat()
                    newPlant.sensorValue = String.format("%.3f", sensorNumber)
                }
                plantList += newPlant
            } catch (e: Exception) {
                Log.e("OverviewViewModel", "Error polling sensor data", e)
            }
        }
        return plantList
    }
}