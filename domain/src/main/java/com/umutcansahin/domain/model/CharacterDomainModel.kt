package com.umutcansahin.domain.model

data class CharacterDomainModel(
    val info: CharacterInfoDM,
    val result: List<CharacterResultDM>
)

data class CharacterInfoDM(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class CharacterResultDM(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocationDM,
    val name: String,
    val origin: CharacterOriginDM,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class CharacterLocationDM(
    val name: String,
    val url: String
)

data class CharacterOriginDM(
    val name: String,
    val url: String
)