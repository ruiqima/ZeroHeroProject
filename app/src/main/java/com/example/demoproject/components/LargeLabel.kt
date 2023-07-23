package com.example.demoproject.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun LargeLabel(labelText: String, color: Color) {
    /**
     * MaterialTheme.colorScheme.onSecondary -> grey
     * MaterialTheme.colorScheme.onBackground -> dark grey
     * MaterialTheme.colorScheme.primary -> green
     */
    Text(
        text = labelText,
        style = MaterialTheme.typography.titleMedium,
        color = color
    )
}