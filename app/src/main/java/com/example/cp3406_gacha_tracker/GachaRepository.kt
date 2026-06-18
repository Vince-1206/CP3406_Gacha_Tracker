package com.example.cp3406_gacha_tracker

import retrofit2.Call

class GachaRepository {

    fun getCharactersFromApi(): Call<List<GachaCharacter>> {
        return RetrofitInstance.api.getCharacters()
    }

    fun getFallbackCharacters(): List<GachaCharacter> {
        return listOf(
            GachaCharacter("Astra", 5, "Fire", "https://via.placeholder.com/150"),
            GachaCharacter("Nova", 5, "Lightning", "https://via.placeholder.com/150"),
            GachaCharacter("Luna", 4, "Ice", "https://via.placeholder.com/150"),
            GachaCharacter("Maple", 4, "Water", "https://via.placeholder.com/150"),
            GachaCharacter("Milo", 3, "Wind", "https://via.placeholder.com/150"),
            GachaCharacter("Kai", 3, "Earth", "https://via.placeholder.com/150")
        )
    }
}