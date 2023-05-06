package com.umutcansahin.domain.use_case

import com.umutcansahin.common.Resource
import com.umutcansahin.domain.model.CharacterResultDomainModel
import com.umutcansahin.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    operator fun invoke(characterId: Int): Flow<Resource<CharacterResultDomainModel>> = flow {
        emit(Resource.Loading)
        emit(Resource.Success(repository.getCharacterById(characterId)))
    }.catch {
        emit(Resource.Error(it.message))
    }
}