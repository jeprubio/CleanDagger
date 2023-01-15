package com.rumosoft.data.infrastructure.di

import com.rumosoft.data.DefaultItemRepository
import com.rumosoft.data.datasource.DefaultRemoteDataSource
import com.rumosoft.data.datasource.RemoteDataSource
import com.rumosoft.domain.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @DataScope
    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource): Repository =
        DefaultItemRepository(remoteDataSource)

    @DataScope
    @Provides
    fun provideRemoteDataSource(): RemoteDataSource =
        DefaultRemoteDataSource()
}
