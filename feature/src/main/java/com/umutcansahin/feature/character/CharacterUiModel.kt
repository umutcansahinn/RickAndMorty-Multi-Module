package com.umutcansahin.feature.character

data class CharacterResultUiModel(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocationUiModel,
    val name: String,
    val origin: CharacterOriginUiModel,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class CharacterLocationUiModel(
    val name: String,
    val url: String
)

data class CharacterOriginUiModel(
    val name: String,
    val url: String
)