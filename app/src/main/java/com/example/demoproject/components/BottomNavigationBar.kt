package com.example.demoproject.components

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.demoproject.model.BottomNavItem
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.viewmodel.EventsViewModelFactory

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit,
    shouldRender: Boolean,
) {
    val viewModel: EventsViewModel = viewModel(
        factory = EventsViewModelFactory()
    )
    if (shouldRender) {
        val backStackEntry = navController.currentBackStackEntryAsState()

        NavigationBar(
            modifier = Modifier.background(MaterialTheme.colorScheme.surface),
            contentColor = Color.Transparent,
            containerColor = Color.Transparent
        ) {
            items.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                NavigationBarItem(selected = selected, onClick = {
                    onItemClick(item)
                }, colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                    unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                    indicatorColor = MaterialTheme.colorScheme.surface
                ), icon = {
                    Icon(imageVector = item.icon, contentDescription = null)
                })
            }
        }
    }
}