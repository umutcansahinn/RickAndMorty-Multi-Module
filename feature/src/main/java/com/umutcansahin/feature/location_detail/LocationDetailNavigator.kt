package com.umutcansahin.feature.location_detail

interface LocationDetailNavigator {
    fun getArgs(): LocationDetailNavArgs
}

data class LocationDetailNavArgs(val locationId: Int)