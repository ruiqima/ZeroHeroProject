package com.example.demoproject.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demoproject.Constants
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.viewmodel.EventsViewModelFactory

@Composable
fun TextInputField(
    placeholderText: String,
    onValueChange: (String) -> Unit = {},
    isPassword: Boolean = false
) {

    val context = LocalContext.current
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )

    val text = remember{ mutableStateOf("") }
    if (isPassword) {
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
                onValueChange(it)
            },
            placeholder = {
                Text(
                    text = placeholderText,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary,
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = MaterialTheme.colorScheme.background,
                textColor = MaterialTheme.colorScheme.onBackground,
                cursorColor = MaterialTheme.colorScheme.onSurface,
                unfocusedBorderColor = MaterialTheme.colorScheme.onSurface,
                focusedBorderColor = MaterialTheme.colorScheme.onSurface,
            ),
            textStyle = MaterialTheme.typography.bodySmall,
            shape = RoundedCornerShape(Constants.ROUNDED_CORNER_SHAPE_SMALL.dp),
        )
    }else{
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
                onValueChange(it)
            },
            placeholder = {
                Text(
                    text = placeholderText,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary,
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = MaterialTheme.colorScheme.background,
                textColor = MaterialTheme.colorScheme.onBackground,
                cursorColor = MaterialTheme.colorScheme.onSurface,
                unfocusedBorderColor = MaterialTheme.colorScheme.onSurface,
                focusedBorderColor = MaterialTheme.colorScheme.onSurface,
            ),
            textStyle = MaterialTheme.typography.bodySmall,
            shape = RoundedCornerShape(Constants.ROUNDED_CORNER_SHAPE_SMALL.dp),
        )
    }
}