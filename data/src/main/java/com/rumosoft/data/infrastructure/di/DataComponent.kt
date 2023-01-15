package com.rumosoft.data.infrastructure.di

import dagger.Subcomponent

@DataScope
@Subcomponent(modules = [DataModule::class])
interface DataComponent
