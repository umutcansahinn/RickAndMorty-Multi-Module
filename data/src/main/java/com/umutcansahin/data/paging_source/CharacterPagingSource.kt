package com.umutcansahin.data.paging_source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.umutcansahin.data.api.RickAndMortyApi
import com.umutcansahin.data.response.character.CharacterResult

class CharacterPagingSource(
    private val rickAndMortyApi: RickAndMortyApi,
): PagingSource<Int,CharacterResult>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterResult> {
        val page = params.key ?: 1
        return try {
            val response = rickAndMortyApi.getAllCharacter(page = page)

           val nextKey = if(response.info == null) {
                null
            } else if (page < response.info.pages!!) {
                page +1
            } else {
                 null
            }

            LoadResult.Page(
                data = response.result ?: emptyList(),
                prevKey = if (page > 1) page-1 else null,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            Log.d("eeeeerrorr", e.localizedMessage.toString())
            LoadResult.Error(e)
        }
    }
}

