package com.umutcansahin.feature.character_detail_bottom_sheet

import com.umutcansahin.domain.model.EpisodeResultDM

fun EpisodeResultDM.toMap(): CharacterBottomSheetUiModel {
    return CharacterBottomSheetUiModel(
        airDate = airDate,
        created = created,
        episode = episode,
        name = name,
        url = url
    )
}