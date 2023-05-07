package com.umutcansahin.feature.character_detail_bottom_sheet

interface CharacterBottomSheetNavigator {
    fun getArgs(): CharacterBottomSheetNavArgs
}

data class CharacterBottomSheetNavArgs(val episodeId: Int)