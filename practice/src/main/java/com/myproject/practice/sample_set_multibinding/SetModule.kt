package com.myproject.practice.sample_set_multibinding

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object SetModule {

    @Provides
    @IntoSet
    fun provideOneString(): String = "ABC"

    @Provides
    @ElementsIntoSet
    fun provideMultipleString(): Set<String>{
        return listOf("DEF", "GHI").toSet()
    }
}