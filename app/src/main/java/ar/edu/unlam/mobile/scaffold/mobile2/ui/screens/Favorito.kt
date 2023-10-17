package ar.edu.unlam.mobile.scaffold.mobile2.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile.scaffold.mobile2.ui.components.mediastack.NewsViewModel
import ar.edu.unlam.mobile.scaffold.mobile2.ui.screens.mediastack.SavedNewsList

@Composable
fun Favorito(viewModel: NewsViewModel, navController: NavHostController) {
    SavedNewsList(viewModel, navController)
}
