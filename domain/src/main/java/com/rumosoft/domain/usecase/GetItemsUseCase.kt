package com.rumosoft.domain.usecase

import com.rumosoft.domain.entities.Item
import com.rumosoft.domain.repository.Repository
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(private val repository: Repository) {
    suspend fun execute(): List<Item> {
        return repository.getItems()
    }
}
