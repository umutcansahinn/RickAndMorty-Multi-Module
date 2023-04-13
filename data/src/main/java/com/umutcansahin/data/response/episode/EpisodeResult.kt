package com.umutcansahin.data.response.episode


import com.google.gson.annotations.SerializedName

data class EpisodeResult(
    @SerializedName("air_date")
    val airDate: String?,
    @SerializedName("characters")
    val characters: List<String>?,
    @SerializedName("created")
    val created: String?,
    @SerializedName("episode")
    val episode: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)