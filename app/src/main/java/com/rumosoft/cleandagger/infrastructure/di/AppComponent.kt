package com.rumosoft.cleandagger.infrastructure.di

import com.rumosoft.cleandagger.MainActivity
import com.rumosoft.cleandagger.MyApplication
import com.rumosoft.data.infrastructure.di.DataComponent
import com.rumosoft.data.infrastructure.di.DataModule
import com.rumosoft.domain.infrastructure.di.DomainComponent
import com.rumosoft.domain.infrastructure.di.DomainModule
import com.rumosoft.presentation.infrastructure.PresentationComponent
import com.rumosoft.presentation.infrastructure.PresentationModule
import dagger.Component

@Component(modules = [DomainModule::class, DataModule::class, PresentationModule::class])
interface AppComponent {
    fun presentationComponent(): PresentationComponent
    fun domainComponent(): DomainComponent
    fun dataComponent(): DataComponent

    fun inject(application: MyApplication)
    fun inject(activity: MainActivity)
}
