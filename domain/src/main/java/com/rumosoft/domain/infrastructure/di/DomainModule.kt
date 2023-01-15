package com.rumosoft.domain.infrastructure.di

import com.rumosoft.domain.repository.Repository
import com.rumosoft.domain.usecase.GetItemsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @DomainScope
    @Provides
    fun provideUseCases(repository: Repository): GetItemsUseCase =
        GetItemsUseCase(repository)
}
