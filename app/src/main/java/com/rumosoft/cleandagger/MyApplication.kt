package com.rumosoft.cleandagger

import android.app.Application
import com.rumosoft.cleandagger.infrastructure.di.AppComponent
import com.rumosoft.cleandagger.infrastructure.di.DaggerAppComponent
import com.rumosoft.presentation.infrastructure.MainProvider
import com.rumosoft.presentation.infrastructure.PresentationModule
import com.rumosoft.presentation.infrastructure.PresentationSubcomponent

class MyApplication : Application(), MainProvider {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    override fun providePresentationComponent(presentationModule: PresentationModule): PresentationSubcomponent {
        return appComponent.presentationComponent().presentationModule(presentationModule).build()
    }
}
