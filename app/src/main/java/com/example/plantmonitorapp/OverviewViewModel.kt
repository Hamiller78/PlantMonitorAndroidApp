package com.example.plantmonitorapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantmonitorapp.network.PlantModel
import com.example.plantmonitorapp.network.PlantWatchApi
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    private val _plants = MutableLiveData<List<PlantModel>>()
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
            } catch (e: Exception) {}
        }
    }
}