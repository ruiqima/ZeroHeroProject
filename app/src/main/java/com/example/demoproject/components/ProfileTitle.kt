package com.example.demoproject.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.demoproject.Constants
import com.example.demoproject.model.UserInfo
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.viewmodel.EventsViewModelFactory

@Composable
fun ProfileTitle(user: UserInfo) {
    val context = LocalContext.current
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )


    Box(modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)
        ) {
        Image(
            painter = rememberAsyncImagePainter(
                viewModel.fileNameToPath(
                    context,
                    user.backgroundImageName
                )
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )
        
        Surface(color = Color.Transparent,
            modifier = Modifier.padding(Constants.SCREEN_HORIZONTAL_PADDING.dp, 0.dp)) {
            Column() {
                Spacer(modifier = Modifier.height(Constants.PAGE_TITLE_TOP_PADDING.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                        ){
                    Image(
                        painter = rememberAsyncImagePainter(
                            viewModel.fileNameToPath(
                                context,
                                user.avatarImageName
                            )
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(Constants.AVATAR_IMAGE_SIZE.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(Constants.CONTENT_PADDING_LARGE.dp))
                    Text(
                        text = viewModel.user.name,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
                Spacer(modifier = Modifier.height(Constants.CARD_CONTENT_PADDING_SMALL.dp))
                Text(
                    text = "From ${ viewModel.user.team } team",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(Constants.CARD_CONTENT_PADDING_SMALL.dp))
            }
        }
    }
}
