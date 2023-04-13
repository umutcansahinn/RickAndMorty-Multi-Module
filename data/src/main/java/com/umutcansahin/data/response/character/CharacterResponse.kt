package com.umutcansahin.data.response.character


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    val info: Info?,
    @SerializedName("results")
    val results: List<CharacterResult?>?
)