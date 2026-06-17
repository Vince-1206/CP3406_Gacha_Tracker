package com.example.cp3406_gacha_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cp3406_gacha_tracker.ui.theme.CP3406_Gacha_TrackerTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_Gacha_TrackerTheme {
                var selectedTab by remember { mutableStateOf(0) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = selectedTab == 0,
                                onClick = { selectedTab = 0 },
                                icon = { Text("🎲") },
                                label = { Text("Gacha") }
                            )

                            NavigationBarItem(
                                selected = selectedTab == 1,
                                onClick = { selectedTab = 1 },
                                icon = { Text("⚙") },
                                label = { Text("Settings") }
                            )
                        }
                    }
                ) { innerPadding ->
                    if (selectedTab == 0) {
                        GachaScreen(modifier = Modifier.padding(innerPadding))
                    } else {
                        SettingsScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
                        }
                    }
                }
            }

@Composable
fun GachaScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Gacha Pull Simulator & Tracker",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Current Banner: Beginner Banner")

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = {}) {
                Text("Pull 1")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {}) {
                Text("Pull 10")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Latest Result: No pull yet")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Pity Counter: 0 / 90")
        Text(text = "Total Pulls: 0")

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Pull History:",
            style = MaterialTheme.typography.titleMedium
        )

        Text(text = "(empty)")
    }
}

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Banner Type: Beginner Banner")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Show Character Images: ON")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "High Rate Demo: OFF")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {}) {
            Text("Reset Pull History")
        }
    }
}