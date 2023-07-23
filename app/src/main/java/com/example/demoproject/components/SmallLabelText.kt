package com.example.demoproject.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SmallLabelText(text: String) {
    Text(text = text, style = MaterialTheme.typography.bodySmall)
}