package com.example.cp3406_gacha_tracker

import androidx.lifecycle.ViewModel

class GachaViewModel : ViewModel() {
    var latestResult = "No pull yet"
    var pityCounter = 0
    var totalPulls = 0
    var pullHistory = listOf<String>()
}