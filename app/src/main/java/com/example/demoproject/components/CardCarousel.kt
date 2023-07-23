package com.example.demoproject.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demoproject.Constants
import com.example.demoproject.model.CardContentItem
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.viewmodel.EventsViewModelFactory

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardCarousel(items: List<CardContentItem>, size: Int) {
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )

    val pagerState = rememberPagerState(
        initialPage = 0, initialPageOffsetFraction = 0f
    ) {
        viewModel.cardContentListSize.value!!
    }

    HorizontalPager(
        modifier = Modifier.fillMaxWidth(Constants.WIDTH_RATIO),
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically
    ) { index ->
        ElevatedCardItem(item = viewModel.cardContentList.value!![index])
    }
}