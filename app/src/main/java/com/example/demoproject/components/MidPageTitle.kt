package com.example.demoproject.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoproject.Constants
import com.example.demoproject.ui.theme.DarkGrey
import com.example.demoproject.ui.theme.fontFamily

@Composable
fun MidPageTitle(titleText: String) {
    Column(modifier = Modifier.padding(8.dp, 0.dp)) {
        Spacer(modifier = Modifier.height((Constants.PAGE_TITLE_TOP_PADDING * 2).dp))
        Text(
            text = titleText,
            style = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 26.sp,
                lineHeight = 26.sp,
                letterSpacing = 1.sp,
                color = DarkGrey
            ),
        )
    }
}