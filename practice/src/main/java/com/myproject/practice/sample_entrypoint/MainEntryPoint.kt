package com.myproject.practice.sample_entrypoint

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface MainEntryPoint {

    fun getEntry(): Entry
}