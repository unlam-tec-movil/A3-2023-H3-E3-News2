package ar.edu.unlam.mobile2.data.weather.repository

import ar.edu.unlam.mobile2.data.weather.network.WeatherResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("current")
    suspend fun getCurrentWeather(
        @Query("access_key") accessKey: String,
        @Query("query") query: String
    ): WeatherResponse
}

