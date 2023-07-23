package com.example.demoproject.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.demoproject.Constants
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.model.CardContentItem
import com.example.demoproject.ui.theme.DarkGrey
import com.example.demoproject.ui.theme.fontFamily
import com.example.demoproject.viewmodel.EventsViewModelFactory

@Composable
fun ElevatedCardItem(
    item: CardContentItem
) {
    val context = LocalContext.current
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )

    val title = item.title
    val content = item.content
    val imagePath = viewModel.fileNameToPath(context, item.imageName)

    Card(
        shape = RoundedCornerShape(Constants.ROUNDED_CORNER_SHAPE.dp),
        elevation = CardDefaults.cardElevation(Constants.CARD_ELEVATION.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
            Box(
                modifier = Modifier
                    .height(Constants.CARD_IMAGE_HEIGHT.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(imagePath),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                modifier = Modifier.padding(
                    Constants.CONTENT_PADDING_LARGE.dp,
                    Constants.CARD_CONTENT_PADDING_SMALL.dp,
                    0.dp,
                    0.dp
                ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(
                        modifier = Modifier.fillMaxWidth(0.7f), text = title, style = TextStyle(
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            letterSpacing = 0.5.sp,
                            color = DarkGrey
                        )
                    )
                    Text(
                        text = content, style = MaterialTheme.typography.bodySmall
                    )
                }
                SmallButton(buttonText = "Join") {}
            }
            Spacer(modifier = Modifier.height(Constants.CONTENT_PADDING_LARGE.dp))
        }
    }
}
