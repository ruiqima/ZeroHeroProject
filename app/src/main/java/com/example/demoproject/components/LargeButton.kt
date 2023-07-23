package com.example.demoproject.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoproject.Constants

@Composable
fun LargeButton(buttonText: String, isEnabled: Boolean = true, onClick: () -> Unit) {
    Button(
        enabled = isEnabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(Constants.BUTTON_HEIGHT.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.onSurface,
        ),
        shape = RoundedCornerShape(20.dp),
        onClick = onClick
    ) {
        Text(text = buttonText, style = MaterialTheme.typography.bodyMedium)
    }

}

@Preview
@Composable
fun ButtonPreview() {
    LargeButton(buttonText = "Create", onClick = {})
}