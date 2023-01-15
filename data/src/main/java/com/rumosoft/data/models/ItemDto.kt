package com.rumosoft.data.models

import com.rumosoft.domain.entities.Item

data class ItemDto(val id: Int)

fun ItemDto.toItem(): Item {
    with(this) {
        return Item(id)
    }
}
