package ar.edu.unlam.mobile.scaffold.mobile2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.mobile2.ui.components.bottomnav.ItemsMenuDW
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    menu_items: List<ItemsMenuDW>){

    Column {

        Image(
            painterResource(id = R.drawable.banner_noticia_dw),
            contentDescription = "Menu de opciones",
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth)
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))

        menu_items.forEach{item ->
            drawerItem(item = item){
                navController.navigate(item.ruta){
                    launchSingleTop = true
                }
                scope.launch{
                    scaffoldState.drawerState.close()
                }
            }
        }
    }

}

@Composable
fun drawerItem(item: ItemsMenuDW, onItemClick: (ItemsMenuDW)-> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(12))
            .padding(8.dp)
            .clickable { onItemClick(item) }
    ) {
        Image(
            painterResource(id = item.icono),
            contentDescription = item.titulo)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = item.titulo,
            style = MaterialTheme.typography.bodyLarge)
    }
}