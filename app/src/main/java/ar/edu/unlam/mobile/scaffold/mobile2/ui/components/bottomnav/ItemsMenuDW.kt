package ar.edu.unlam.mobile.scaffold.mobile2.ui.components.bottomnav

import ar.edu.unlam.mobile.scaffold.R

sealed class ItemsMenuDW(
    val icono: Int,
    val titulo: String,
    val ruta: String,

    ) {
    object PantallaGoogle : ItemsMenuDW(R.drawable.pin_location_map_marker_placeholder_icon_146263, "Ubicacion","pantallaGoogle")

}


