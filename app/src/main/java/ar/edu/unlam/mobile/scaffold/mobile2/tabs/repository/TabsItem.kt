package ar.edu.unlam.mobile2.Tabs.repository

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile2.mediastackapi.viewmodel.NewsViewModel

typealias miFuncion = @Composable () -> Unit

sealed class TabsItem(
    var icon: Int,
    var title: String,
    var screen: miFuncion,

) {
    class ItemGeneral(viewModel: NewsViewModel, navController: NavHostController) :
        TabsItem(R.drawable.ic_launcher_foreground, "General", { General(viewModel, navController) })

    class ItemBusiness(viewModel: NewsViewModel, navController: NavHostController) :
        TabsItem(R.drawable.ic_launcher_foreground, "Business", { Business(viewModel, navController) })

    class ItemEntertainment(viewModel: NewsViewModel, navController: NavHostController) :
        TabsItem(R.drawable.ic_launcher_foreground, "Entertainment", { Entertainment(viewModel, navController) })

    class ItemHealth(viewModel: NewsViewModel, navController: NavHostController) :
        TabsItem(R.drawable.ic_launcher_foreground, "Health", { Health(viewModel, navController) })

    class ItemScience(viewModel: NewsViewModel, navController: NavHostController) :
        TabsItem(R.drawable.ic_launcher_foreground, "Science", { Science(viewModel, navController) })

    class ItemSports(viewModel: NewsViewModel, navController: NavHostController) :
        TabsItem(R.drawable.ic_launcher_foreground, "Sports", { Sports(viewModel, navController) })

    class ItemTechnology(viewModel: NewsViewModel, navController: NavHostController) :
        TabsItem(R.drawable.ic_launcher_foreground, "Technology", { Technology(viewModel, navController) })
}
