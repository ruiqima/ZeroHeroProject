package com.example.demoproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.demoproject.Constants
import com.example.demoproject.components.BackButtonAppBar
import com.example.demoproject.components.DropDownMenuInputField
import com.example.demoproject.components.EventMap
import com.example.demoproject.components.LargeButton
import com.example.demoproject.components.LargeLabel
import com.example.demoproject.components.TextInputField
import com.example.demoproject.services.ServiceManager
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.viewmodel.EventsViewModelFactory

@Composable
fun CreateEventScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )

    var selectedCity: String by remember { mutableStateOf("Redlands") }

    val cities = arrayOf("Redlands", "Highland", "Los Angeles", "Menlo Park", "San Francisco")

    val activityTypes = arrayOf(
        "Nature Noshing",
        "Waste Warriors",
        "Upcycle Palooza",
        "Compost Champions",
        "Canopy Crusaders",
        "Marvelous Market",
        "Stream Safari",
        "Move Mitigation",
        "Litter Quest",
        "Beach Beautification"
    )

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        BackButtonAppBar(navController = navController, labelText = "Create an event")
        Column(modifier = Modifier.padding(Constants.SCREEN_HORIZONTAL_PADDING.dp, 0.dp)) {
            LargerSpacer()
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Box(modifier = Modifier.fillMaxWidth(0.45f)) {
                    DropDownMenuInputField(cities) { city -> selectedCity = city }
                }
                Box(modifier = Modifier.fillMaxWidth()) {
                    DropDownMenuInputField(activityTypes, {})
                }
            }
            SmallerSpacer()
            if (selectedCity == "Redlands") {
                EventMap("6bf9ae62ccac4fc28431a5928219a786")
            } else {
                EventMap("5d6d3926961f4089bbbb88e3a484a9ec")
            }
            LargerSpacer()
            LargeLabel(
                labelText = "Title is",
                color = MaterialTheme.colorScheme.onSecondary
            )
            SmallerSpacer()
            TextInputField(
                placeholderText = "",
                onValueChange = { title -> viewModel.updateEventTitle(title) })
            LargerSpacer()
            LargeLabel(
                labelText = "I add a slogan to it",
                color = MaterialTheme.colorScheme.onSecondary
            )
            SmallerSpacer()
            TextInputField(
                placeholderText = "",
                onValueChange = { content -> viewModel.updateEventContent(content) })
            LargerSpacer()
            LargeButton(
                buttonText = "Create",
                isEnabled = viewModel.eventTitle.isNotEmpty() and viewModel.eventContent.isNotEmpty()
            ) {
                ServiceManager(context).startNotificationService()
                val savedStateHandle = navController.previousBackStackEntry?.savedStateHandle
                savedStateHandle?.set("title", viewModel.eventTitle)
                savedStateHandle?.set("content", viewModel.eventContent)

                navController.popBackStack()
            }
            LargerSpacer()
        }

    }
}

@Composable
fun LargerSpacer() {
    Spacer(modifier = Modifier.height(Constants.CONTENT_PADDING_LARGE.dp))
}

@Composable
fun SmallerSpacer() {
    Spacer(modifier = Modifier.height((Constants.CONTENT_PADDING_LARGE * 0.6).dp))
}
