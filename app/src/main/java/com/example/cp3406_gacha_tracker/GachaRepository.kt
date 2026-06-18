package com.example.cp3406_gacha_tracker

import retrofit2.Call

class GachaRepository {

    fun getCharactersFromApi(): Call<List<GachaCharacter>> {
        return RetrofitInstance.api.getCharacters()
    }

    fun getFallbackCharacters(): List<GachaCharacter> {
        return listOf(
            GachaCharacter("Astra", 5, "Fire"),
            GachaCharacter("Nova", 5, "Lightning"),
            GachaCharacter("Luna", 4, "Ice"),
            GachaCharacter("Rin", 4, "Water"),
            GachaCharacter("Milo", 3, "Wind"),
            GachaCharacter("Kai", 3, "Earth")
        )
    }
}