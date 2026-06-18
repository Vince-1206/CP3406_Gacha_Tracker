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
import com.example.cp3406_gacha_tracker.ui.theme.CP3406_Gacha_TrackerTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_Gacha_TrackerTheme {
                val gachaViewModel: GachaViewModel = viewModel()
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
                        GachaScreen(
                            modifier = Modifier.padding(innerPadding),
                            viewModel = gachaViewModel
                        )
                    } else {
                        SettingsScreen(
                            modifier = Modifier.padding(innerPadding),
                            viewModel = gachaViewModel
                        )
                    }
                }
                        }
                    }
                }
            }

@Composable
fun GachaScreen(
    modifier: Modifier = Modifier,
    viewModel: GachaViewModel
) {
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
            Button(onClick = {viewModel.pullOne()}) {
                Text("Pull 1")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { viewModel.pullTen() }) {
                Text("Pull 10")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Latest Result: ${viewModel.latestResult.value}")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Pity Counter: ${viewModel.pityCounter.value} / 90")
        Text(text = "Total Pulls: ${viewModel.totalPulls.value}")

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Pull History:",
            style = MaterialTheme.typography.titleMedium
        )

        if (viewModel.pullHistory.isEmpty()) {
            Text(text = "(empty)")
        } else {
            LazyColumn {
                items(viewModel.pullHistory) { result ->
                    Text(text = "- $result")
                }
            }
        }
    }
}

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: GachaViewModel
) {
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

        Row {
            Text(text = "High Rate Demo")

            Spacer(modifier = Modifier.width(16.dp))

            Switch(
                checked = viewModel.highRateDemo.value,
                onCheckedChange = { viewModel.toggleHighRateDemo() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {viewModel.resetHistory() }) {
            Text("Reset Pull History")
        }
    }
}