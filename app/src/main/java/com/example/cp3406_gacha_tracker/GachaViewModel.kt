package com.example.cp3406_gacha_tracker

import androidx.lifecycle.ViewModel

class GachaViewModel : ViewModel() {

    private val repository = GachaRepository()

    val characters = repository.getCharacters()

    var latestResult = "No pull yet"
    var pityCounter = 0
    var totalPulls = 0
    var pullHistory = listOf<String>()
}