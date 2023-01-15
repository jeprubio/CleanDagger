package com.rumosoft.data.datasource

import com.rumosoft.data.models.ItemDto
import kotlinx.coroutines.delay
import javax.inject.Inject

class DefaultRemoteDataSource @Inject constructor() : RemoteDataSource {
    override suspend fun getItems(): List<ItemDto> {
        delay(3_000)
        return (1..3).map {
            ItemDto(it)
        }
    }
}
