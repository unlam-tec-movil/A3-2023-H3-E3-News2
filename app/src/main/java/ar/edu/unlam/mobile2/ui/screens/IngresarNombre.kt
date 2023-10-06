package ar.edu.unlam.mobile2.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.ui.components.guest.GuestViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngresarNombre(navHostController: NavHostController, guestViewModel: GuestViewModel) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        IngresarNombreContainer(navHostController, guestViewModel)
    }
}

@Composable
fun IngresarNombreContainer(navHostController: NavHostController, guestViewModel: GuestViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ingrese su nombre", color = Color.White)
        MyTextField(navHostController, guestViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(navHostController: NavHostController, guestViewModel: GuestViewModel) {
    var name by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) }

    Column {
        TextField(value = name, onValueChange = {
            name = it
            nameError = false
        }, label = { Text("Nombre") }, isError = nameError
        )
        val assistiveElementText = if (nameError) "Error: Obligatorio" else "*Obligatorio"
        val assistiveElementColor = if (nameError) {
            MaterialTheme.colors.error
        } else {
            MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
        }
        Text(
            text = assistiveElementText,
            color = assistiveElementColor,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(Modifier.size(16.dp))
        Button(
            onClick = {
                if (name.isNotBlank()){
                    guestViewModel.actualizarBase(name)
                    navHostController.navigate("pantalla1") {
                        popUpTo("ingresar-nombre-screen") { inclusive = true }
                    }
                }else{
                    nameError = name.isBlank()
                }
            }, modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Continuar")
        }
    }
}
