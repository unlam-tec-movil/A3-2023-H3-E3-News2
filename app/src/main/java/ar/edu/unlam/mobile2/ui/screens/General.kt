package ar.edu.unlam.mobile2.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.ui.components.mediastack.NewsList
import ar.edu.unlam.mobile2.ui.components.mediastack.NewsViewModel
import ar.edu.unlam.mobile2.ui.components.weather.WeatherScreen
import ar.edu.unlam.mobile2.ui.screens.weather.WeatherViewModel

@Composable
fun Inicio (weatherViewModel: WeatherViewModel, viewModel: NewsViewModel, navController: NavHostController){

    Box(modifier = Modifier.fillMaxSize()) {
        NewsList(viewModel,0,navController)
        WeatherScreen(weatherViewModel)
    }
}