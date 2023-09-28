package ar.edu.unlam.mobile2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile2.ui.components.bottomnav.ItemsMenu
import ar.edu.unlam.mobile2.ui.components.bottomnav.NavegationHost
import ar.edu.unlam.mobile2.Tabs.repository.Tabs_item
import ar.edu.unlam.mobile2.ui.components.tabs.Tabs
import ar.edu.unlam.mobile2.ui.components.tabs.Tabs_content
import ar.edu.unlam.mobile2.ui.components.mediastack.NewsViewModel
import ar.edu.unlam.mobile2.ui.theme.Mobile2_ScaffoldingTheme
import ar.edu.unlam.mobile2.ui.screens.weather.WeatherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import ar.edu.unlam.mobile2.ui.components.BotonFlotante
import ar.edu.unlam.mobile2.ui.components.MainTopAppBar
import ar.edu.unlam.mobile2.ui.components.guest.GuestViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val weatherViewModel by viewModels<WeatherViewModel>()
    private val newViewModel by viewModels<NewsViewModel>()
    private val guestViewModel by viewModels<GuestViewModel>()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "719d2c40-5de1-44d8-980d-aded581ac26d",
            Analytics::class.java, Crashes::class.java
        )
        setContent {
            Mobile2_ScaffoldingTheme {
                PantallaPrincipal(weatherViewModel = weatherViewModel, viewModel = newViewModel, guestViewModel = guestViewModel)
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaPrincipal(weatherViewModel: WeatherViewModel, viewModel: NewsViewModel, guestViewModel: GuestViewModel) {

    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navegationItem = listOf(
        ItemsMenu.Pantalla1,
        ItemsMenu.Pantalla2,
        ItemsMenu.Pantalla3
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colorScheme.background,
        scaffoldState = scaffoldState,
        topBar = { MainTopAppBar(navController) },
        content = {
            Column(
                Modifier
                    .fillMaxSize(),
            ) {
                NavegationHost(
                    navHostController = navController,
                    weatherViewModel = weatherViewModel,
                    viewModel = viewModel,
                    guestViewModel = guestViewModel,
                    new = viewModel.resivirNoticia()
                )
            }
        },
        bottomBar = { NavegacionInferior(navController, navegationItem,viewModel) },
        floatingActionButton = { BotonFlotante(navController,viewModel) }
    )
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}

@Composable
fun NavegacionInferior(navController: NavHostController, menuItem: List<ItemsMenu>, viewModel: NewsViewModel) {
    val visible = viewModel.isVisible.value
    if (visible) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.onBackground
    ) {
        BottomNavigation(backgroundColor = MaterialTheme.colorScheme.onBackground) {
            val currentRoute = currentRoute(navController = navController)
            menuItem.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.ruta,
                    onClick = { navController.navigate(item.ruta) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icono!!),
                            contentDescription = item.titulo,
                            tint = (if (currentRoute == item.ruta) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                Color.White
                            })
                        )
                    }
                )


            }
        }
    }}
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun Tabs_Principal(viewModel: NewsViewModel, navController: NavHostController) {
    val tabs = listOf(
        Tabs_item.item_general(viewModel,navController),
        Tabs_item.item_business(viewModel,navController),
        Tabs_item.item_entertainment(viewModel,navController),
        Tabs_item.item_health(viewModel,navController),
        Tabs_item.item_science(viewModel,navController),
        Tabs_item.item_sports(viewModel,navController),
        Tabs_item.item_technology(viewModel,navController)


    )
    val pagerState = rememberPagerState()
    Column() {
        Tabs(tabs, pagerState)
        Tabs_content(tabs, pagerState)
    }
}
