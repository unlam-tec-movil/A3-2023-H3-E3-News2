package ar.edu.unlam.mobile.scaffold.mobile2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile.scaffold.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainTopAppBar(navController: NavHostController, scope: CoroutineScope,
                  scaffoldState: ScaffoldState) {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.background,
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = "Boton Menu",
                    tint = Color.White,
                    modifier = Modifier.clickable { scope.launch { scaffoldState.drawerState.open() } })

                Spacer(modifier = Modifier.width(10.dp))
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(id = R.drawable.unlam_blanco), contentDescription = "Logo",tint = Color.White)

            }
            Spacer(modifier = Modifier.width(10.dp))
        },
        title = {
            Text(text = "Noticias UNLaM", color = Color.White)},
        actions = {
            IconButton(onClick = {
                navController.navigate("settings-screen")
            }) {
                Icon(imageVector = Icons.Filled.Build, contentDescription = "Configuración", tint = Color.White)
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
