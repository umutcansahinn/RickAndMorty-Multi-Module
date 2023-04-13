package com.umutcansahin.feature.character_detail

data class CharacterDetailResultUiModel(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterDetailLocationUiModel,
    val name: String,
    val origin: CharacterDetailOriginUiModel,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class CharacterDetailLocationUiModel(
    val name: String,
    val url: String
)

data class CharacterDetailOriginUiModel(
    val name: String,
    val url: String
)