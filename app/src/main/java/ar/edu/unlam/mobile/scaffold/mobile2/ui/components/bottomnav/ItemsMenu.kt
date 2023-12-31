package ar.edu.unlam.mobile.scaffold.mobile2.ui.components.bottomnav

import ar.edu.unlam.mobile.scaffold.R

sealed class ItemsMenu(
    val icono: Int?,
    val titulo: String,
    val ruta: String,

) {
    object Pantalla1 : ItemsMenu(R.drawable.baseline_language_24, "General", "pantalla1")
    object Pantalla2 : ItemsMenu(R.drawable.baseline_bookmarks_24, "Favoritos", "pantalla2")
    object Pantalla3 : ItemsMenu(R.drawable.baseline_filter_alt_24, "Filtrar", "pantalla3")
    object Pantalla4 : ItemsMenu(R.drawable.baseline_add_24, "Anadir", "pantalla4")
    object Pantalla5 : ItemsMenu(R.drawable.baseline_add_24, "NoticaScreen", "pantalla5")
    object IngresarNombreScreen : ItemsMenu(R.drawable.baseline_add_24, titulo = "IngresarNombreScreen", ruta = "ingresar-nombre-screen")

    object SettingsScreen : ItemsMenu(R.drawable.baseline_add_24, titulo = "SettingsScreen", ruta = "settings-screen")
    object SplashScreen : ItemsMenu(R.drawable.unlam_blanco, titulo = "SplashScreen", ruta = "splash-screen")
}
