package no.uka.aas

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainScaffold() {
    var selectedIndex by remember { mutableStateOf(0) }

    val backgroundOrange = Color(0xFFFFA23A)
    val navBarOrange = Color(0xFFFFB96B)

    // Juster disse hvis du vil
    val jumpUp = (-10).dp
    val circleSize = 40.dp
    val selectedCircleColor = Color.White.copy(alpha = 0.22f)

    data class NavItem(
        val label: String,
        val icon: @Composable () -> Unit
    )

    val items = listOf(
        NavItem("Hjem") { Icon(Icons.Outlined.Home, contentDescription = "Home") },
        NavItem("Program") { Icon(Icons.Outlined.CalendarMonth, contentDescription = "Program") },
        NavItem("Lineup") { Icon(Icons.Outlined.Mic, contentDescription = "Lineup") },
        NavItem("Kart") { Icon(Icons.Outlined.Map, contentDescription = "Map") },
        NavItem("Innstillinger") { Icon(Icons.Outlined.Settings, contentDescription = "Settings") }
    )

    Scaffold(
        containerColor = backgroundOrange,
        bottomBar = {
            NavigationBar(containerColor = navBarOrange) {
                items.forEachIndexed { index, item ->
                    val selected = selectedIndex == index
                    val yOffset by animateDpAsState(
                        targetValue = if (selected) jumpUp else 0.dp,
                        label = "navJump"
                    )

                    NavigationBarItem(
                        selected = selected,
                        onClick = { selectedIndex = index },

                        // Viktig: Fjerner Material sin "pill"/indicator bak valgt item
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent,
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color.White.copy(alpha = 0.80f),
                            selectedTextColor = Color.White,
                            unselectedTextColor = Color.White.copy(alpha = 0.80f)
                        ),

                        // Vi styrer selv label-visning
                        alwaysShowLabel = false,
                        label = {
                            if (selected) Text(item.label)
                        },

                        icon = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.offset(y = yOffset)
                            ) {
                                if (selected) {
                                    Box(
                                        modifier = Modifier
                                            .size(circleSize)
                                            .clip(CircleShape)
                                            .background(selectedCircleColor),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        item.icon()
                                    }
                                } else {
                                    item.icon()
                                }
                            }
                        }
                    )
                }
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


