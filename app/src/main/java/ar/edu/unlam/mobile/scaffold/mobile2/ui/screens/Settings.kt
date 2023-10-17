package ar.edu.unlam.mobile.scaffold.mobile2.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.mobile2.ui.components.guest.GuestViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Settings(viewModel: GuestViewModel) {
    Scaffold() {
        SettingsContainer(viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsContainer(viewModel: GuestViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var name by remember { mutableStateOf("") }
        var nameError by remember { mutableStateOf(false) }

        Row(modifier = Modifier.fillMaxWidth()) {
            Column {
                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                        nameError = false
                    },
                    label = { Text("Nombre") },
                    isError = nameError,
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
                    modifier = Modifier.padding(start = 16.dp),
                )
            }

            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        viewModel.actualizarBase(name)
                    } else {
                        nameError = name.isBlank()
                    }
                },
            ) {
                Text("Continuar")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
private fun SettingsPreview() {
}
