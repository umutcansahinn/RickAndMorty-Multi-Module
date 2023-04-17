package com.umutcansahin.data.response.episode


import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("info")
    val info: EpisodeInfo,
    @SerializedName("results")
    val result: List<EpisodeResult>?
)