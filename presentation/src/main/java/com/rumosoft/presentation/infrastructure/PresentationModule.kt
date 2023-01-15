package com.rumosoft.presentation.infrastructure

import androidx.lifecycle.ViewModelProvider
import com.rumosoft.domain.usecase.GetItemsUseCase
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @PresentationScope
    @Provides
    fun provideViewModelFactory(useCases: GetItemsUseCase): ViewModelProvider.Factory {
        return ViewModelFactory(useCases)
    }
}
