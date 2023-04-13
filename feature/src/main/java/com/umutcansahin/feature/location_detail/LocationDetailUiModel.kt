package com.umutcansahin.feature.location_detail

data class LocationDetailResultUiModel(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)