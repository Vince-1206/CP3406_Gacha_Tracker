package com.example.cp3406_gacha_tracker

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GachaViewModel : ViewModel() {

    private val repository = GachaRepository()
    private var characters = repository.getFallbackCharacters()

    var latestResult = mutableStateOf("No pull yet")
    var pityCounter = mutableStateOf(0)
    var totalPulls = mutableStateOf(0)
    var highRateDemo = mutableStateOf(false)

    val pullHistory = mutableStateListOf<String>()

    var apiStatus = mutableStateOf("Loading character data...")

    var latestImageUrl = mutableStateOf("")

    init {
        loadCharactersFromApi()
    }
    private fun loadCharactersFromApi() {
        repository.getCharactersFromApi().enqueue(object : Callback<List<GachaCharacter>> {
            override fun onResponse(
                call: Call<List<GachaCharacter>>,
                response: Response<List<GachaCharacter>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    characters = response.body()!!
                    apiStatus.value = "Character data loaded from GitHub API"
                } else {
                    apiStatus.value = "Using fallback character data"
                }
            }

            override fun onFailure(
                call: Call<List<GachaCharacter>>,
                t: Throwable

            ) {
                apiStatus.value = "Using fallback character data"
                // fallback already loaded
            }
        })
    }

    fun pullOne() {
        totalPulls.value += 1
        pityCounter.value += 1

        val selectedCharacter = getRandomCharacter()
        latestImageUrl.value = selectedCharacter.imageUrl

        latestResult.value =
            "${selectedCharacter.name} - ${selectedCharacter.rarity}★ - ${selectedCharacter.element}"

        pullHistory.add(0, latestResult.value)

        if (selectedCharacter.rarity == 5) {
            pityCounter.value = 0
        }
    }
    fun pullTen() {
        repeat(10) {
            pullOne()
        }
    }

    fun toggleHighRateDemo() {
        highRateDemo.value = !highRateDemo.value
    }

    fun resetHistory() {
        latestResult.value = "No pull yet"
        pityCounter.value = 0
        totalPulls.value = 0
        pullHistory.clear()
    }

    private fun getRandomCharacter(): GachaCharacter {
        val rarity = if (pityCounter.value >= 90) {
            5
        } else {
            val chance = Random.nextInt(100)

            if (highRateDemo.value) {
                when {
                    chance < 20 -> 5
                    chance < 50 -> 4
                    else -> 3
                }
            } else {
                when {
                    chance < 1 -> 5
                    chance < 11 -> 4
                    else -> 3
                }
            }
        }


        return characters
            .filter { it.rarity == rarity }
            .random()
    }
}