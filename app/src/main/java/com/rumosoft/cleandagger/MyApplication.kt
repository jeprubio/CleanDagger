package com.rumosoft.cleandagger

import android.app.Application
import com.rumosoft.cleandagger.infrastructure.di.AppComponent
import com.rumosoft.cleandagger.infrastructure.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
    }
}
