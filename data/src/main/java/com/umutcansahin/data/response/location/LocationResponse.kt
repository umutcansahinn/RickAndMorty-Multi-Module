package com.umutcansahin.data.response.location


import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("info")
    val info: LocationInfo,
    @SerializedName("result")
    val result: List<LocationResult>?
)