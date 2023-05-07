package com.umutcansahin.rickandmortymultimodulekotlindsl.navigator

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.umutcansahin.feature.character.CharacterFragmentDirections
import com.umutcansahin.feature.character.CharacterNavigator
import com.umutcansahin.rickandmortymultimodulekotlindsl.R
import javax.inject.Inject

class CharacterNavigatorImpl @Inject constructor(private val fragment: Fragment) :
    CharacterNavigator {
    override fun navigate(characterId: Int) {
        Navigation.findNavController(fragment.requireActivity(), R.id.fragmentContainer).navigate(
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(characterId = characterId)
        )
    }
}