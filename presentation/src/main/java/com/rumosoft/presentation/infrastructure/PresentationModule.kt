package com.rumosoft.presentation.infrastructure

import androidx.lifecycle.ViewModelProvider
import com.rumosoft.domain.usecase.GetItemsUseCase
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(val parameter: Int) {

    @Provides
    fun provideMultiplicator(): Multiplicator = Multiplicator(parameter)

    @PresentationScope
    @Provides
    fun provideViewModelFactory(useCases: GetItemsUseCase): ViewModelProvider.Factory {
        return ViewModelFactory(useCases)
    }
}

class Multiplicator(val parameter: Int) {
    fun multiply(parameter2: Int) = parameter * parameter2
}
