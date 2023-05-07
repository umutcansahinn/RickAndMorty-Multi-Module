package com.umutcansahin.rickandmortymultimodulekotlindsl.navigator

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.umutcansahin.feature.character_detail_bottom_sheet.CharacterBottomSheetFragmentArgs
import com.umutcansahin.feature.character_detail_bottom_sheet.CharacterBottomSheetNavArgs
import com.umutcansahin.feature.character_detail_bottom_sheet.CharacterBottomSheetNavigator
import javax.inject.Inject

class CharacterBottomSheetNavigatorImpl @Inject constructor(private val fragment: Fragment) :
    CharacterBottomSheetNavigator {
    override fun getArgs(): CharacterBottomSheetNavArgs {
        with(fragment) {
            val args: CharacterBottomSheetFragmentArgs by navArgs()
            return CharacterBottomSheetNavArgs(args.episodeId)
        }
    }
}