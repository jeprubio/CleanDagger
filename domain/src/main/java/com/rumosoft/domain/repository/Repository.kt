package com.rumosoft.domain.repository

import com.rumosoft.domain.entities.Item

interface Repository {
    suspend fun getItems(): List<Item>
}
