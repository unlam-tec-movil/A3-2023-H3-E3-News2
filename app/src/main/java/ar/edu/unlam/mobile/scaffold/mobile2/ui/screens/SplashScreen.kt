package ar.edu.unlam.mobile.scaffold.mobile2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MySplashScreen(
    navigate: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.unlam_blanco),
            contentDescription = "app-logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .fillMaxSize(),
        )
    }

    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            delay(2000)
            navigate()
        }
    }
}
