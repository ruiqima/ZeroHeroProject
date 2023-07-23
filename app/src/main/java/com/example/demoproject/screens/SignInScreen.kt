package com.example.demoproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.demoproject.Constants
import com.example.demoproject.components.LargeButton
import com.example.demoproject.components.SmallLabelButton
import com.example.demoproject.components.TextInputField
import com.example.demoproject.navigation.Screen
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.viewmodel.EventsViewModelFactory
import java.io.File

@Composable
fun SignInScreen(navController: NavController) {
    val context = LocalContext.current
    val logoFileName = "logo.png"
    val logoFilePath = File(context.filesDir, logoFileName)
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                Constants.SCREEN_HORIZONTAL_PADDING.dp
            )
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = rememberAsyncImagePainter(logoFilePath),
            contentDescription = null,
            modifier = Modifier
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height((Constants.CONTENT_PADDING_LARGE * 2).dp))
        TextInputField(
            placeholderText = "Username",
            onValueChange = { name -> viewModel.updateUserName(name) })
        Spacer(modifier = Modifier.height((Constants.CONTENT_PADDING_LARGE * 1.2).dp))
        TextInputField(placeholderText = "Password", onValueChange = { ps ->
            viewModel.updatePassword(ps)
        },
        isPassword = true)
        Spacer(modifier = Modifier.height(Constants.CONTENT_PADDING_LARGE.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SmallLabelButton("Forgot password?", {})
            SmallLabelButton("Sign up", {})
        }
        Spacer(modifier = Modifier.height((Constants.CONTENT_PADDING_LARGE * 2.4).dp))
        LargeButton(buttonText = "Sign In", isEnabled = viewModel.userName.isNotEmpty() and viewModel.password.isNotEmpty()) {
            navController.navigate(Screen.InterestScreen.route)
        }
    }
}