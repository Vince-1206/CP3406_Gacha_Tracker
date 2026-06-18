package com.example.cp3406_gacha_tracker

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GachaViewModel : ViewModel() {

    private val repository = GachaRepository()
    private val characters = repository.getCharacters()

    var latestResult = mutableStateOf("No pull yet")
    var pityCounter = mutableStateOf(0)
    var totalPulls = mutableStateOf(0)

    val pullHistory = mutableStateListOf<String>()

    fun pullOne() {
        totalPulls.value += 1
        pityCounter.value += 1

        val selectedCharacter = getRandomCharacter()

        latestResult.value =
            "${selectedCharacter.name} - ${selectedCharacter.rarity}★ - ${selectedCharacter.element}"

        pullHistory.add(0, latestResult.value)

        if (selectedCharacter.rarity == 5) {
            pityCounter.value = 0
        }
    }

    private fun getRandomCharacter(): GachaCharacter {
        val rarity = if (pityCounter.value >= 90) {
            5
        } else {
            val chance = Random.nextInt(100)
            when {
                chance < 1 -> 5
                chance < 11 -> 4
                else -> 3
            }
        }

        return characters
            .filter { it.rarity == rarity }
            .random()
    }
}