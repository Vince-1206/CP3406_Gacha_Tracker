package com.example.cp3406_gacha_tracker

class GachaRepository {

    private val characters = listOf(
        GachaCharacter("Astra", 5, "Fire"),
        GachaCharacter("Luna", 4, "Ice"),
        GachaCharacter("Milo", 3, "Wind"),
        GachaCharacter("Nova", 5, "Lightning"),
        GachaCharacter("Rin", 4, "Water"),
        GachaCharacter("Kai", 3, "Earth")
    )

    fun getCharacters(): List<GachaCharacter> {
        return characters
    }
}