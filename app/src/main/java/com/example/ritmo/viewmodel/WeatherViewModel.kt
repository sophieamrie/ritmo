package com.example.ritmo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ritmo.data.remote.WeatherRepository
import com.example.ritmo.model.WeatherResponse
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = WeatherRepository()

    private val _weather = MutableLiveData<WeatherResponse?>()
    val weather: LiveData<WeatherResponse?> = _weather

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = repository.getWeather(city, apiKey)
                if (response.isSuccessful) {
                    _weather.value = response.body()
                } else {
                    _error.value = "Failed to fetch weather"
                }
            } catch (e: Exception) {
                _error.value = "No internet connection"
            } finally {
                _isLoading.value = false
            }
        }
    }
}