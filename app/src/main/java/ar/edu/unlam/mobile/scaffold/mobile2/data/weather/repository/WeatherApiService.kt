<<<<<<<< HEAD:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/data/weather/repository/WeatherApiService.kt
package ar.edu.unlam.mobile.scaffold.mobile2.data.weather.repository

import ar.edu.unlam.mobile.scaffold.mobile2.data.weather.network.WeatherResponse
========
package ar.edu.unlam.mobile2.weatherapi.repository

import ar.edu.unlam.mobile2.weatherapi.data.WeatherResponse
>>>>>>>> develop:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/weatherapi/repository/WeatherApiService.kt
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("current")
    suspend fun getCurrentWeather(
        @Query("access_key") accessKey: String,
        @Query("query") query: String,
    ): WeatherResponse
}
