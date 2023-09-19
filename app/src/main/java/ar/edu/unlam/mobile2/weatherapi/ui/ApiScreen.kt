package ar.edu.unlam.mobile2.weatherapi.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.ui.theme.Mobile2_ScaffoldingTheme
import ar.edu.unlam.mobile2.weatherapi.data.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Preview(showSystemUi = true)
@Composable
fun MyWeatherPreview() {
    val weatherData by remember { mutableStateOf<WeatherResponse?>(null) }

    Mobile2_ScaffoldingTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .padding()
                    .align(Alignment.TopEnd),
                backgroundColor = MaterialTheme.colorScheme.background.copy(alpha = 0.8f),
                shape = CutCornerShape(1.dp)
            ) {
                Row(
                    modifier = Modifier.padding(1.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (weatherData == null) {
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "${10}°c",
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Nublado",
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    } else {
                        Text("Loading weather data...", color = Color.White)
                    }
                }

            }
        }
    }


}

@Composable
fun WeatherScreen(weatherViewModel: WeatherViewModel) {
    var weatherData by remember { mutableStateOf<WeatherResponse?>(null) }

    LaunchedEffect(Unit) {
        val data = withContext(Dispatchers.IO) {
            weatherViewModel.getWeatherData("Buenos Aires")
        }
        weatherData = data
    }

    Mobile2_ScaffoldingTheme {
        Box(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .padding()
                    .align(Alignment.TopEnd),
                backgroundColor = MaterialTheme.colorScheme.background.copy(alpha = 0.9f),
                shape = CutCornerShape(1.dp)
            ) {
                Row(
                    modifier = Modifier.padding(1.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (weatherData != null) {
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "${weatherData!!.current.temperature}°c",
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "${weatherData!!.current.weatherDescriptions}",
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    } else {
                        Text("Loading weather data...", color = Color.White)
                    }
                }

            }
        }
    }

}

//${weatherData!!.current.temperature}°c
//${weatherData!!.current.weatherDescriptions}