package com.umutcansahin.domain.model

data class LocationDomainModel(
    val info: LocationInfoDomainModel,
    val result: List<LocationResultDomainModel>
)

data class LocationInfoDomainModel(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class LocationResultDomainModel(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)