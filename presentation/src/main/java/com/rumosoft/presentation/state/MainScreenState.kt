package com.rumosoft.presentation.state

import com.rumosoft.domain.entities.Item

sealed interface MainScreenState {
    object Loading : MainScreenState
    data class Data(val data: List<Item>) : MainScreenState
}
