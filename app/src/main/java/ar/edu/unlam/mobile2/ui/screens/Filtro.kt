package ar.edu.unlam.mobile2.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.Tabs_Principal
import ar.edu.unlam.mobile2.ui.components.mediastack.NewsViewModel

@Composable
fun Filtro(viewModel: NewsViewModel, navController: NavHostController) {
    Tabs_Principal(viewModel, navController)
}
