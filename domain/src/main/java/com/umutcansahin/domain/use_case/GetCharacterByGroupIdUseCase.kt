package com.umutcansahin.domain.use_case

import com.umutcansahin.common.Resource
import com.umutcansahin.domain.model.CharacterResultDM
import com.umutcansahin.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterByGroupIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(characterGroupId: String): Resource<List<CharacterResultDM>> {
        return try {
            Resource.Loading
            Resource.Success(repository.getCharacterByGroupId(characterGroupId = characterGroupId))
        }catch (e: Exception) {
            Resource.Error(e.message)
        }
    }
}