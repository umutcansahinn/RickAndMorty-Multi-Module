package com.umutcansahin.domain.use_case

import com.umutcansahin.common.Resource
import com.umutcansahin.domain.model.CharacterResultDM
import com.umutcansahin.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(characterId: Int): Resource<CharacterResultDM> {
        return try {
            Resource.Loading
            Resource.Success(repository.getCharacterById(characterId = characterId))
        }catch (e: Exception) {
            Resource.Error(e.localizedMessage)
        }
    }
}