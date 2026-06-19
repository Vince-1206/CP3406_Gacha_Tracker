package com.example.cp3406_gacha_tracker

import retrofit2.Call

class GachaRepository {

    fun getCharactersFromApi(): Call<List<GachaCharacter>> {
        return RetrofitInstance.api.getCharacters()
    }

    fun getFallbackCharacters(): List<GachaCharacter> {
        return listOf(
            GachaCharacter("Astra", 5, "Fire", "https://www.image2url.com/r2/default/images/1781866238083-ea1f30c3-630d-4db2-97d7-f2fec2fd03a2.jpg"),
            GachaCharacter("Nova", 5, "Lightning", "https://www.image2url.com/r2/default/images/1781866465910-f6646192-b319-4598-9fa2-9403049b6138.jpg"),
            GachaCharacter("Luna", 4, "Ice", "https://www.image2url.com/r2/default/images/1781866505366-44e74fb1-1241-4970-a8d6-9c36670118ca.jpg"),
            GachaCharacter("Maple", 4, "Water", "https://www.image2url.com/r2/default/images/1781866593542-65403ddf-ee3a-4db8-b410-850353f5033b.jpg"),
            GachaCharacter("Milo", 3, "Wind", "https://www.image2url.com/r2/default/images/1781866905032-e348d1e2-46c8-46b4-868b-bb801d7ae2b9.jpg"),
            GachaCharacter("Kai", 3, "Earth", "https://www.image2url.com/r2/default/images/1781866814848-cfd6622f-68e2-44a4-b3bb-2615c24bbb83.jpg")
        )
    }
}