package com.example.demoproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.demoproject.R
import com.example.demoproject.components.GifImage
import com.example.demoproject.navigation.Screen
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

@Composable
fun InitialScreen(navController: NavController) {

    LaunchedEffect(Unit){
        coroutineScope {
            delay(3000)
            navController.navigate(Screen.SignInScreen.route)
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)){
        Column() {
            Spacer(modifier = Modifier.height(200.dp))
            GifImage(modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(), R.drawable.initgif)
        }

    }

}