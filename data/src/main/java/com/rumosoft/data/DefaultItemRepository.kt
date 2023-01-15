package com.rumosoft.data

import com.rumosoft.data.datasource.RemoteDataSource
import com.rumosoft.data.models.toItem
import com.rumosoft.domain.entities.Item
import com.rumosoft.domain.repository.Repository
import javax.inject.Inject

class DefaultItemRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    Repository {

    override suspend fun getItems(): List<Item> {
        return remoteDataSource.getItems().map { it.toItem() }
    }
}
