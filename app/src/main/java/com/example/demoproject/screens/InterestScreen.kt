package com.example.demoproject.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.demoproject.Constants
import com.example.demoproject.components.LargeButton
import com.example.demoproject.components.MidPageTitle
import com.example.demoproject.components.MultiSelectionChips
import com.example.demoproject.navigation.Screen
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.viewmodel.EventsViewModelFactory

@Composable
fun InterestScreen(navController: NavController) {
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                Constants.SCREEN_HORIZONTAL_PADDING.dp
            )
    ){
        MidPageTitle(titleText = "Choose your sustainable interests")
        Spacer(modifier = Modifier.height(Constants.CONTENT_PADDING_LARGE.dp))
        MultiSelectionChips()
        Spacer(modifier = Modifier.height((Constants.CONTENT_PADDING_LARGE * 2.4).dp))
        LargeButton(buttonText = "Submit", isEnabled = viewModel.selectedListSize > 0) {
            viewModel.updateIsInMainUI(true)
            navController.navigate(Screen.EventsScreen.route)
        }
    }
}