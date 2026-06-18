package com.example.cp3406_gacha_tracker

import retrofit2.Call
import retrofit2.http.GET

interface GachaApiService {

    @GET("Vince-1206/CP3406_Gacha_Tracker/refs/heads/master/characters.json")
    fun getCharacters(): Call<List<GachaCharacter>>
}