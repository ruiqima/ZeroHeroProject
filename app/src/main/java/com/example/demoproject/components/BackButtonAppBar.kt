package com.example.demoproject.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.demoproject.Constants

@Composable
fun BackButtonAppBar(navController: NavController, labelText: String = "") {
    Column(horizontalAlignment = Alignment.Start) {
        Spacer(modifier = Modifier.height(Constants.PAGE_TITLE_TOP_PADDING.dp))
        Row() {
            Box(modifier = Modifier.clickable(onClick = {
                navController.popBackStack()
            })) {
                Icon(
                    modifier = Modifier.padding(
                        Constants.SCREEN_HORIZONTAL_PADDING.dp, 0.dp

                    ),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.width(Constants.CONTENT_PADDING_LARGE.dp))
            LargeLabel(
                labelText = labelText,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}