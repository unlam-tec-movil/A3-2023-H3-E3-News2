package ar.edu.unlam.mobile.scaffold.mobile2.ui.screens.weather

import androidx.lifecycle.ViewModel
import ar.edu.unlam.mobile.scaffold.mobile2.data.weather.network.WeatherResponse
import ar.edu.unlam.mobile.scaffold.mobile2.data.weather.repository.WeatherStackRepository
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
