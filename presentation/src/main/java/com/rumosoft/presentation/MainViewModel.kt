package com.rumosoft.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumosoft.domain.usecase.GetItemsUseCase
import com.rumosoft.presentation.state.MainScreenState
import com.rumosoft.presentation.state.MainScreenState.Data
import com.rumosoft.presentation.state.MainScreenState.Loading
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val useCase: GetItemsUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<MainScreenState>(Loading)
    val uiState: StateFlow<MainScreenState> = _uiState

    fun getItems() =
        viewModelScope.launch {
            val items = useCase.execute()
            _uiState.update {
                Data(data = items)
            }
        }
}
