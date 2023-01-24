package com.rumosoft.presentation.infrastructure

import com.rumosoft.presentation.BlankActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationSubcomponent {
    @Subcomponent.Builder
    interface Builder {
        fun presentationModule(module: PresentationModule): Builder
        fun build(): PresentationSubcomponent
    }

    fun inject(activity: BlankActivity)
}
