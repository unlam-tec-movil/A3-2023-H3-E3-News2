package ar.edu.unlam.mobile2.Tabs.repository


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.ui.components.mediastack.NewsList
import ar.edu.unlam.mobile2.ui.components.mediastack.NewsViewModel


@Composable
fun General(viewModel: NewsViewModel, navController: NavHostController) {
    NewsList(viewModel, 1,navController)
}


@Composable
fun Business(viewModel: NewsViewModel, navController: NavHostController) {
    NewsList(viewModel, 2,navController)
}

@Composable
fun Entertainment(viewModel: NewsViewModel, navController: NavHostController) {
    NewsList(viewModel, 3,navController)
}

@Composable
fun Health(viewModel: NewsViewModel, navController: NavHostController) {
    NewsList(viewModel, 4,navController)
}

@Composable
fun Science(viewModel: NewsViewModel, navController: NavHostController) {
    NewsList(viewModel, 5,navController)
}

@Composable
fun Sports(viewModel: NewsViewModel, navController: NavHostController) {
    NewsList(viewModel, 6,navController)
}

@Composable
fun Technology(viewModel: NewsViewModel, navController: NavHostController) {
    NewsList(viewModel, 7,navController)
}





