package com.example.ritmo.data.remote

import com.example.ritmo.model.WeatherResponse
import retrofit2.Response
import retrofit2.Retrofit

class WeatherRepository {

    private val apiService = RetrofitClient.weatherApiService

    suspend fun getWeather(city: String, apiKey: String): Response<WeatherResponse> {
        return apiService.getCurrentWeather(city, apiKey)
    }
}