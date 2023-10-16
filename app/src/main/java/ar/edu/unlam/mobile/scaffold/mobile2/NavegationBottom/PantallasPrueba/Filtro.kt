package ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba // ktlint-disable package-name
// ktlint-disable package-name

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.Tabs_Principal
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel

@Composable
fun Filtro(viewModel: NewsViewModel, navController: NavHostController) {
    Tabs_Principal(viewModel, navController)
}
