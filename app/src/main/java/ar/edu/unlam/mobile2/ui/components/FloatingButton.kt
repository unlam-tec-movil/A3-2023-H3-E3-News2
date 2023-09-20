package ar.edu.unlam.mobile2.ui.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.ui.components.mediastack.NewsViewModel

@Composable
fun BotonFlotante(navController: NavHostController, viewModel: NewsViewModel) {
    //var visible by remember { mutableStateOf(true) }
     var visible = viewModel.isFloatingButtonVisible.value
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            // Slide in from 40 dp from the top.
            with(density) { -40.dp.roundToPx() }
        } + expandVertically(
            // Expand from the top.
            expandFrom = Alignment.Top
        ) + fadeIn(
            // Fade in with the initial alpha of 0.3f.
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ) {
        IconButton(onClick = {
            navController.navigate("pantalla4")
            visible = !visible
            Log.i("CLICK", "Click")
            Log.i("Visible", visible.toString())
        },
            colors = IconButtonDefaults.iconButtonColors(Color.White)) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }
    }

}

/*
var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            // Slide in from 40 dp from the top.
            with(density) { -40.dp.roundToPx() }
        } + expandVertically(
            // Expand from the top.
            expandFrom = Alignment.Top
        ) + fadeIn(
            // Fade in with the initial alpha of 0.3f.
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ) {
        IconButton(onClick = {
            onClickNavigation()
            visible = !visible
            Log.i("CLICK", "Click")
            Log.i("Visible", visible.toString())
        }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }
    }

    BOTON DE FACU
    val isFloatingButtonVisible = viewModel.isFloatingButtonVisible.value
    if (isFloatingButtonVisible) {
        FloatingActionButton(
            modifier = Modifier.size(55.dp, 55.dp),
            containerColor = MaterialTheme.colorScheme.primary,
            onClick = {

                navController.navigate("pantalla4")
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "añadir-noticias",
                tint = Color.Black
            )

        }
    }
 */