package com.rumosoft.data.datasource

import com.rumosoft.data.models.ItemDto

interface RemoteDataSource {
    suspend fun getItems(): List<ItemDto>
}
