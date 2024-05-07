package com.myproject.practice.sample_bindsoptionalof

import dagger.BindsOptionalOf
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class OptionalModule {

    @BindsOptionalOf
    abstract fun abstractOptionalSample(): OptionalSample
}