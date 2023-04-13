package com.umutcansahin.domain.use_case

import com.umutcansahin.domain.model.CharacterResultDM
import com.umutcansahin.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(characterId: Int): CharacterResultDM {
        return repository.getCharacterById(characterId)
    }
}