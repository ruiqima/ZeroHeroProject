package com.example.demoproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.LocalActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.demoproject.components.BottomNavigationBar
import com.example.demoproject.model.BottomNavItem
import com.example.demoproject.navigation.Navigation
import com.example.demoproject.ui.theme.DemoProjectTheme
import com.example.demoproject.viewmodel.EventsViewModel
import com.example.demoproject.viewmodel.EventsViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoProjectTheme {
                MainUI()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainUI() {
    val navController = rememberNavController()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.tertiary
    ) {
        Navigation(navController = navController)
    }
}