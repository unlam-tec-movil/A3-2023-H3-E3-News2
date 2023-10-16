package ar.edu.unlam.mobile2.NavegationBottom.PantallasPrueba // ktlint-disable package-name
// ktlint-disable package-name

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.mediastackapi.ui.SavedNewsList
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel

@Composable
fun Favorito(viewModel: NewsViewModel, navController: NavHostController) {
    SavedNewsList(viewModel, navController)
}
