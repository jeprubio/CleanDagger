package com.rumosoft.presentation.infrastructure

interface MainProvider {
    fun providePresentationComponent(presentationModule: PresentationModule): PresentationSubcomponent
}
