package com.rumosoft.domain.infrastructure.di

import com.rumosoft.domain.repository.Repository
import dagger.Subcomponent

@DomainScope
@Subcomponent(modules = [DomainModule::class])
interface DomainComponent {
    fun repository(): Repository
}
