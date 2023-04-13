package com.umutcansahin.data.response.location


import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("info")
    val info: Info?,
    @SerializedName("result")
    val result: List<LocationResult>?
)