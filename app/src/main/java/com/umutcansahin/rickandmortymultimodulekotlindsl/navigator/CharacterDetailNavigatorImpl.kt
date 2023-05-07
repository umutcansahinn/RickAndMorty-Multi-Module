package com.umutcansahin.rickandmortymultimodulekotlindsl.navigator

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.umutcansahin.feature.character_detail.CharacterDetailFragmentArgs
import com.umutcansahin.feature.character_detail.CharacterDetailFragmentDirections
import com.umutcansahin.feature.character_detail.CharacterDetailNavArgs
import com.umutcansahin.feature.character_detail.CharacterDetailNavigator
import com.umutcansahin.rickandmortymultimodulekotlindsl.R
import javax.inject.Inject

class CharacterDetailNavigatorImpl @Inject constructor(
    private val fragment: Fragment
) : CharacterDetailNavigator {
    override fun getArgs(): CharacterDetailNavArgs {
        with(fragment) {
            val args: CharacterDetailFragmentArgs by navArgs()
            return CharacterDetailNavArgs(args.characterId)
        }
    }

    override fun navigate(episodeId: Int) {
        Navigation.findNavController(fragment.requireActivity(), R.id.fragmentContainer).navigate(
            CharacterDetailFragmentDirections
                .actionCharacterDetailFragmentToCharacterBottomSheet(episodeId = episodeId)
        )
    }
}