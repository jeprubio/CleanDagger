package com.rumosoft.presentation

import android.app.Activity
import android.os.Bundle

import com.rumosoft.presentation.databinding.ActivityBlankBinding
import com.rumosoft.presentation.infrastructure.MainProvider
import com.rumosoft.presentation.infrastructure.Multiplicator
import com.rumosoft.presentation.infrastructure.PresentationModule
import javax.inject.Inject

class BlankActivity : Activity() {
    private lateinit var binding: ActivityBlankBinding

    @Inject
    lateinit var multiplicator: Multiplicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MainProvider)
            .providePresentationComponent(PresentationModule(5))
            .inject(this)

        binding = ActivityBlankBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.value.text = multiplicator.multiply(3).toString()
    }
}
