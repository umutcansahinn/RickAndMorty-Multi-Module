package com.umutcansahin.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.umutcansahin.data.api.RickAndMortyApi
import com.umutcansahin.data.response.location.LocationResult

class LocationPagingSource(
    private val rickAndMortyApi: RickAndMortyApi,
): PagingSource<Int, LocationResult>() {

    override fun getRefreshKey(state: PagingState<Int, LocationResult>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationResult> {
        val page = params.key ?: 1
        return try {
            val response = rickAndMortyApi.getAllLocation(page = page)

            val nextKey = if(response.info?.pages == null) {
                null
            } else if (page < response.info.pages) {
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
            LoadResult.Error(e)
        }
    }
}