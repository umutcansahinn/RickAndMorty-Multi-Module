package com.umutcansahin.feature.character_detail_bottom_sheet

import com.umutcansahin.domain.model.EpisodeResultDomainModel

fun EpisodeResultDomainModel.toCharacterBottomSheetUiModel(): CharacterBottomSheetUiModel {
    return CharacterBottomSheetUiModel(
        airDate = airDate,
        created = created,
        episode = episode,
        name = name,
        url = url
    )
}