package ar.edu.unlam.mobile2.ui.screens

import android.Manifest
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.content.PermissionChecker
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.ui.components.mediastack.NewsViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Definir una variable para almacenar la ubicación de la imagen capturada
var capturedImageUri: Uri? = null

// Definir un FileProvider para la imagen capturada
val capturedImageFileProvider = "com.tuapp.fileprovider"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anadir(navHostController: NavHostController, viewMode: NewsViewModel) {
    val context = LocalContext.current
    var titulo by remember { mutableStateOf("") } // titulo
    var descripcion by remember { mutableStateOf("") } // descripcion
    var categoria by remember { mutableStateOf("") } // categoria
    var pais by remember { mutableStateOf("") } // pais

    // Aca implemente la variable de estado para la imagen capturada.
    var capturedImage by remember { mutableStateOf<Bitmap?>(null) }

    // Variable para verificar si se han otorgado permisos de cámara.
    var hasCameraPermission by remember { mutableStateOf(false) }

    // Crear un launcher para solicitar permisos de cámara.
    val launcher: ActivityResultLauncher<String> = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
    ) { isGranted ->
        if (isGranted) {
            hasCameraPermission = true
        } else {
            // Aquí podemos manejar el caso en el que el usuario no otorga los permisos de cámara
        }
    }

    // Función para solicitar permisos de cámara.
    fun requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PermissionChecker.PERMISSION_GRANTED) {
            // Si los permisos ya se han otorgado previamente.
            hasCameraPermission = true
        } else {
            // Si los permisos no se han otorgado, solicitarlos.
            launcher.launch(Manifest.permission.CAMERA)
        }
    }

    // Crear un launcher para capturar imágenes
    val captureImageLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            // La imagen se capturó con éxito, ahora procesarla.
            capturedImageUri?.let { uri ->
                // Accede a la imagen en uri y guárdala en capturedImage
                val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
                capturedImage = bitmap
            }
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            TopAppBar(
                title = { Text(text = "") },
                backgroundColor = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth(),

                actions = {
                    Button(
                        onClick = {
                            viewMode.guardarNoticiaLocal(
                                autor = "Guest",
                                title = titulo,
                                description = descripcion,
                                category = categoria,
                                country = pais,
                            )
                            navHostController.popBackStack()
                        },
                        modifier = Modifier.padding(end = 16.dp), // Espacio entre el botón y el borde derecho
                    ) {
                        Text(text = "publicar")
                    }
                },
            )
        }

        item {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Titulo",
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .padding(start = 16.dp),

            )
            Spacer(modifier = Modifier.height(5.dp))
            TextField(
                value = titulo,
                onValueChange = {
                    titulo = it
                },
                label = {
                    Text("Ingrese el Titulo")
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(height = 50.dp, width = 600.dp),
            )
            Text(
                text = "Descripcion",
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .padding(start = 16.dp),

            )
            Spacer(modifier = Modifier.height(5.dp))
            TextField(
                value = descripcion,
                onValueChange = {
                    descripcion = it
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(height = 130.dp, width = 600.dp),
            )
            Row() {
                Text(
                    text = "Categoria",
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier
                        .padding(start = 16.dp),
                )
                Text(
                    text = "Pais",
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier
                        .padding(start = 130.dp),
                )
            }
            Row() {
                TextField(
                    value = categoria,
                    onValueChange = {
                        categoria = it
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(height = 50.dp, width = 170.dp),
                )
                TextField(
                    value = pais,
                    onValueChange = {
                        pais = it
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(height = 50.dp, width = 170.dp),
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = Color.Gray,
            )

            // Mostramos la imagen capturada, si existe.
            capturedImage?.let { image ->
                Image(
                    bitmap = image.asImageBitmap(),
                    contentDescription = "Imagen capturada",
                    modifier = Modifier
                        .size(500.dp)
                        .padding(16.dp),
                )
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd,
    ) {
        FloatingActionButton(
            modifier = Modifier
                .size(100.dp, 100.dp)
                .padding(16.dp),

            containerColor = MaterialTheme.colorScheme.primary,
            onClick = {
                if (hasCameraPermission) {
                    val imageFile = createImageFile(context)
                    capturedImageUri = FileProvider.getUriForFile(context, capturedImageFileProvider, imageFile)
                    captureImageLauncher.launch(capturedImageUri)
                    // Implementamos aquí la lógica para abrir la cámara y tomar una foto.
                    // Nos aseguramos de guardar la imagen capturada en capturedImage.
                } else {
                    // Si no se han otorgado permisos, solicitarlos.
                    requestCameraPermission()
                }
            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                contentDescription = "Camara",
                tint = Color.Black,
            )
        }
    }
}

// funcion para crear el archivo de la imagen
private fun createImageFile(context: Context): File {
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir)
}
