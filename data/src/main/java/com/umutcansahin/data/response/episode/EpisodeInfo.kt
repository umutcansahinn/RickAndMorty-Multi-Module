package com.umutcansahin.data.response.episode


import com.google.gson.annotations.SerializedName

data class EpisodeInfo(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("prev")
    val prev: Any?
)