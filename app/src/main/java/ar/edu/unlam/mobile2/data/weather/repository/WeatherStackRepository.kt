package ar.edu.unlam.mobile2.data.weather.repository

import ar.edu.unlam.mobile2.data.weather.network.WeatherResponse

class WeatherStackRepository(private val api: WeatherApiService) {

    suspend fun getWeatherData(location: String): WeatherResponse {
        val apiKey = "8d692815449ebb14abb97d4562ae4c59"
        return api.getCurrentWeather(apiKey, location)
    }
}
