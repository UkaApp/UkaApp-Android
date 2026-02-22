package no.uka.aas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Settings

@Composable
fun MainScaffold() {
    var selectedIndex by remember { mutableStateOf(0) }

    val backgroundOrange = Color(0xFFFFA23A)
    val navBarOrange = Color(0xFFFFB96B)

    Scaffold(
        containerColor = backgroundOrange,
        bottomBar = {
            NavigationBar(containerColor = navBarOrange) {

                NavigationBarItem(
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0 },
                    icon = { Icon(Icons.Outlined.Home, contentDescription = "Home") }
                )

                NavigationBarItem(
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1 },
                    icon = { Icon(Icons.Outlined.CalendarMonth, contentDescription = "Program") }
                )

                NavigationBarItem(
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 },
                    icon = { Icon(Icons.Outlined.Mic, contentDescription = "Lineup") }
                )

                NavigationBarItem(
                    selected = selectedIndex == 3,
                    onClick = { selectedIndex = 3 },
                    icon = { Icon(Icons.Outlined.Map, contentDescription = "Map") }
                )
                NavigationBarItem(
                    selected = selectedIndex == 4,
                    onClick = { selectedIndex = 4 },
                    icon = { Icon(Icons.Outlined.Settings, contentDescription = "Settings") }
                )
            }
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(backgroundOrange)
        ) {
            when (selectedIndex) {
                0 -> HomeView()
                1 -> ProgramView()
                2 -> LineupView()
                3 -> MapView()
                4 -> SettingsView()
            }
        }
    }
}



