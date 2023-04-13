package com.umutcansahin.data.response.location


import com.google.gson.annotations.SerializedName

data class LocationInfo(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("prev")
    val prev: Any?
)