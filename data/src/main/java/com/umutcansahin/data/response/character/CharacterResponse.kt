package com.umutcansahin.data.response.character


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("locationInfo")
    val info: CharacterInfo,
    @SerializedName("results")
    val result: List<CharacterResult>?
)