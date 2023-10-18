package ar.edu.unlam.mobile.scaffold.mobile2.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MyGoogleMap(){
    val argentina = LatLng(-34.61315, -58.37723)
    val universidadUnlam = LatLng(-34.6703392,-58.5664591)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(argentina, 10f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = argentina),
            title = "Argentina",
            snippet = "Buenos Aires"
        )

        Marker(
            state = MarkerState(position = universidadUnlam),
            title= "Unlam",
            snippet = "Universidad"
        )

        Polyline(points = listOf(
            universidadUnlam,
            argentina
        ), color = Color.Red)
    }
}