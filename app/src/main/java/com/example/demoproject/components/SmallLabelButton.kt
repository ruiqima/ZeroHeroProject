package com.example.demoproject.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SmallLabelButton(text: String, onClick : ()->Unit) {
    Box(modifier = Modifier.clickable(onClick = onClick)) {
        Text(text = text, style = MaterialTheme.typography.bodySmall)
    }
}