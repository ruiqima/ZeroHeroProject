package com.example.demoproject.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demoproject.Constants
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.viewmodel.EventsViewModelFactory

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MultiSelectionChips() {
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )
    FlowRow(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(Constants.CHIPS_HORIZONTAL_AXIS_SPACING.dp),
        verticalArrangement = Arrangement.spacedBy((Constants.CHIPS_VERTICAL_AXIS_SPACING * 2).dp)
    ) {
        viewModel.activityTypes.forEach { item ->
            ChipItem(
                labelText = item,
                onClick = {
                    if (viewModel.isContainingLabel(item)) viewModel.removeFromMultiSelectedChipLabelList(
                        item
                    )
                    else viewModel.addToMultiSelectedChipLabelList(item)
                },
                isSelected = viewModel.isContainingLabel(item),
                selectedListSize = viewModel.selectedListSize
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SingleSelectionChips() {
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )
    FlowRow(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(Constants.CHIPS_HORIZONTAL_AXIS_SPACING.dp),
        verticalArrangement = Arrangement.spacedBy(Constants.CHIPS_VERTICAL_AXIS_SPACING.dp)
    ) {
        viewModel.activityTypes.forEach { item ->
            ChipItem(
                labelText = item, onClick = {
                    viewModel.updateSingleSelectedChipLabel(item)
                }, isSelected = viewModel.singleSelectedChipLabel == item
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipItem(
    labelText: String, onClick: () -> Unit, isSelected: Boolean, selectedListSize: Int = 0
) {
    Chip(
        shape = RoundedCornerShape(Constants.ROUNDED_CORNER_SHAPE_SMALL.dp),
        border = if (isSelected) null else BorderStroke(
            Constants.LIGHT_BORDER_WIDTH.dp, MaterialTheme.colorScheme.onSurface
        ),
        onClick = onClick,
        colors = if (isSelected) ChipDefaults.chipColors(
            backgroundColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
        else ChipDefaults.chipColors(
            backgroundColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Text(
            modifier = Modifier.padding(8.dp, 6.dp),
            text = labelText,
            style = MaterialTheme.typography.labelLarge,
            color = if (isSelected) MaterialTheme.colorScheme.onPrimary
            else MaterialTheme.colorScheme.onBackground
        )
    }
}