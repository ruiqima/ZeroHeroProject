package com.example.demoproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class Constants {

    // style
    companion object{
        const val ROUNDED_CORNER_SHAPE = 50
        const val ROUNDED_CORNER_SHAPE_SMALL = 10
        const val CARD_ELEVATION = 5
        const val CONTENT_PADDING_LARGE = 24
        const val CARD_CONTENT_PADDING_SMALL = 12
        const val WIDTH_RATIO = 0.9f
        const val CARD_IMAGE_HEIGHT = 90
        const val BUTTON_HEIGHT = 50
        const val SCREEN_HORIZONTAL_PADDING = 24
        const val PAGE_TITLE_TOP_PADDING = 36
        const val AVATAR_IMAGE_SIZE = 60
        const val CHIPS_HORIZONTAL_AXIS_SPACING = 8
        const val CHIPS_VERTICAL_AXIS_SPACING = 4
        const val LIGHT_BORDER_WIDTH = 1

        val borderModifier = Modifier.border(BorderStroke(2.dp, Color.Blue))
    }
}