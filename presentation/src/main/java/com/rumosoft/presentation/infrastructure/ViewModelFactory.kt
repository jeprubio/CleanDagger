package com.rumosoft.presentation.infrastructure

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rumosoft.domain.usecase.GetItemsUseCase
import com.rumosoft.presentation.MainViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val useCases: GetItemsUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(useCases) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
