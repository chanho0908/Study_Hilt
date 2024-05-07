package com.myproject.practice.sample_custom_component

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import java.time.LocalDateTime

@DefineComponent.Builder
interface DialogComponentBuilder {

    fun setLocalDateTime(@BindsInstance localDateTime: LocalDateTime): DialogComponentBuilder
    fun build(): DialogComponent
}