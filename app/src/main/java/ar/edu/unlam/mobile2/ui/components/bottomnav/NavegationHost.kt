package ar.edu.unlam.mobile2.ui.components.bottomnav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.unlam.mobile2.domain.mediastack.models.New
import ar.edu.unlam.mobile2.ui.components.guest.GuestViewModel
import ar.edu.unlam.mobile2.ui.components.mediastack.NewsViewModel
import ar.edu.unlam.mobile2.ui.screens.Anadir
import ar.edu.unlam.mobile2.ui.screens.Favorito
import ar.edu.unlam.mobile2.ui.screens.Filtro
import ar.edu.unlam.mobile2.ui.screens.IngresarNombre
import ar.edu.unlam.mobile2.ui.screens.Inicio
import ar.edu.unlam.mobile2.ui.screens.MySplashScreen
import ar.edu.unlam.mobile2.ui.screens.Settings
import ar.edu.unlam.mobile2.ui.screens.mediastack.NoticaScreen
import ar.edu.unlam.mobile2.ui.screens.weather.WeatherViewModel

@Composable
fun NavegationHost(
    navHostController: NavHostController,
    weatherViewModel: WeatherViewModel,
    viewModel: NewsViewModel,
    guestViewModel: GuestViewModel,
    new: New,
) {
    val existeGuest by guestViewModel.existeGuest.observeAsState(initial = false)

    NavHost(
        navController = navHostController,
        startDestination = ItemsMenu.SplashScreen.ruta,
    ) {
        composable(ItemsMenu.IngresarNombreScreen.ruta) {
            viewModel.hideItem()
            IngresarNombre(navHostController, guestViewModel)
        }
        composable(ItemsMenu.Pantalla1.ruta) {
            viewModel.showItem()
            Inicio(weatherViewModel, viewModel, navHostController)
        }
        composable(ItemsMenu.Pantalla2.ruta) {
            viewModel.showItem()
            Favorito(viewModel = viewModel, navHostController)
        }
        composable(ItemsMenu.Pantalla3.ruta) {
            viewModel.showItem()
            Filtro(viewModel, navHostController)
        }
        composable(ItemsMenu.Pantalla4.ruta) {
            viewModel.hideItem()
            Anadir(navHostController, viewModel)
        }
        composable(ItemsMenu.Pantalla5.ruta) {
            viewModel.showItem()
            val new2 = viewModel.resivirNoticia()
            NoticaScreen(new2, navHostController)
        }
        composable(ItemsMenu.SettingsScreen.ruta) {
            viewModel.hideItem()
            Settings(guestViewModel)
        }
        composable(ItemsMenu.SplashScreen.ruta) {
            MySplashScreen(
                navigate = {
                    navHostController.navigate(if (existeGuest) ItemsMenu.Pantalla1.ruta else ItemsMenu.IngresarNombreScreen.ruta)
                },
            )
        }
    }
}
