package ar.edu.unlam.mobile.scaffold.mobile2.ui.components

import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.R

@Composable
fun MainTopAppBar(navController: NavHostController) {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.background,
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(id = R.drawable.unlam_blanco), contentDescription = "Logo")
            }
        },
        title = { Text(text = "Noticias UNLaM") },
        actions = {
            IconButton(onClick = {
                navController.navigate("settings-screen")
            }) {
                Icon(imageVector = Icons.Filled.Build, contentDescription = "Configuración")
            }
        },
    )
}

/*TopAppBar(
backgroundColor = MaterialTheme.colorScheme.background
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .padding(start = 5.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.unlam_blanco),
            tint = Color.White,
            contentDescription = "Logo-Unlam-Blanco",
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "UNLaM News",
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

 */
