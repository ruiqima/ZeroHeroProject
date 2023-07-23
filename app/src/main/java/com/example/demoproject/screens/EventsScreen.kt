package com.example.demoproject.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.demoproject.Constants
import com.example.demoproject.components.CardCarousel
import com.example.demoproject.components.EventMap
import com.example.demoproject.components.LargeLabel
import com.example.demoproject.components.PageTitle
import com.example.demoproject.components.SmallButton
import com.example.demoproject.components.SmallLabelText
import com.example.demoproject.model.CardContentItem
import com.example.demoproject.navigation.Screen
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.viewmodel.EventsViewModelFactory

@Composable
fun EventsScreen(navController: NavController, entry: NavBackStackEntry) {
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )
    val newEventTitle = entry.savedStateHandle.get<String>("title")
    val newEventContent = entry.savedStateHandle.get<String>("content")

    newEventTitle?.let {
        newEventContent?.let {
            Log.d("EventsScreen", "in screen")
            viewModel.addToCardContentList(
                CardContentItem(
                    title = newEventTitle,
                    content = newEventContent,
                    imageName = viewModel.chooseRandomImageFromList()
                )
            )
            entry.savedStateHandle.remove<String>("title")
            entry.savedStateHandle.remove<String>("content")
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .padding(Constants.SCREEN_HORIZONTAL_PADDING.dp, 0.dp)
        ) {
            PageTitle(titleText = "Events") {
                navController.navigate(Screen.VisualizationScreen.route)
            }
            EventMap("197d07b5e0f04eff937364f75f7c7b8e")
            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                SmallLabelText("Find your neighboring Eco-Warriors!")
            }
            Spacer(modifier = Modifier.height(Constants.CONTENT_PADDING_LARGE.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    LargeLabel(
                        labelText = "All Events",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    SmallLabelText("Join these events and enjoy!")
                }
                SmallButton(buttonText = "Create") {
                    navController.navigate(Screen.CreateEventScreen.route)
                }
            }
        }
        Spacer(modifier = Modifier.height((Constants.CONTENT_PADDING_LARGE * 0.8).dp))
        CardCarousel(
            items = viewModel.cardContentList.value!!,
            size = viewModel.cardContentListSize.value!!
        )
        Spacer(modifier = Modifier.height(Constants.CONTENT_PADDING_LARGE.dp))
    }

}