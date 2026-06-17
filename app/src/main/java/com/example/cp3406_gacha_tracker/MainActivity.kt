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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_Gacha_TrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
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
            }
        }
    }
}