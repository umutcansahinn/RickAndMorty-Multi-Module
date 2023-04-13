package com.umutcansahin.domain.model

data class LocationDomainModel(
    val info: LocationInfo,
    val result: List<LocationResult>
)

data class LocationInfo(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class LocationResult(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)