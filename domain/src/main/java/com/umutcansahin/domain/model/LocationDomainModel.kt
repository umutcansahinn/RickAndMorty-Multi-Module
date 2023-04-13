package com.umutcansahin.domain.model

data class LocationDomainModel(
    val info: LocationInfoDM,
    val result: List<LocationResultDM>
)

data class LocationInfoDM(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class LocationResultDM(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)