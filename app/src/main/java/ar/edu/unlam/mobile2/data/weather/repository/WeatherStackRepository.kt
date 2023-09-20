package ar.edu.unlam.mobile2.data.weather.repository

import ar.edu.unlam.mobile2.data.weather.network.WeatherResponse

class WeatherStackRepository(private val api: WeatherApiService) {

    suspend fun getWeatherData(location: String): WeatherResponse {
        val apiKey = "debabb07ba0c44c04f09ef7eb7846757"
        return api.getCurrentWeather(apiKey, location)
    }
}
