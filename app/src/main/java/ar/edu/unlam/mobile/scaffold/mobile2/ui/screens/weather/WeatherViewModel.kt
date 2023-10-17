<<<<<<<< HEAD:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/ui/screens/weather/WeatherViewModel.kt
package ar.edu.unlam.mobile.scaffold.mobile2.ui.screens.weather

import androidx.lifecycle.ViewModel
import ar.edu.unlam.mobile.scaffold.mobile2.data.weather.network.WeatherResponse
import ar.edu.unlam.mobile.scaffold.mobile2.data.weather.repository.WeatherStackRepository
========
package ar.edu.unlam.mobile2.weatherapi.ui

import androidx.lifecycle.ViewModel
import ar.edu.unlam.mobile2.weatherapi.data.WeatherResponse
import ar.edu.unlam.mobile2.weatherapi.repository.WeatherStackRepository
>>>>>>>> develop:app/src/main/java/ar/edu/unlam/mobile/scaffold/mobile2/weatherapi/ui/WeatherViewModel.kt
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherStackRepository,
) : ViewModel() {

    suspend fun getWeatherData(location: String): WeatherResponse {
        return repository.getWeatherData(location)
    }
}
