package com.example.demoproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.demoproject.components.BackButtonAppBar
import java.io.File

@Composable
fun VisualizationScreen(navController: NavController) {
    val context = LocalContext.current
    Column() {
        BackButtonAppBar(navController, labelText = "Dashboard")
        Image(
            painter = rememberAsyncImagePainter(File(context.filesDir, "dashboard.PNG")),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize().padding(8.dp, 0.dp)
        )
    }
}