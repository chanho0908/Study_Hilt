package com.myproject.practice.sample_binds

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class EngineModule {

//    @Binds
//    abstract fun bindEngine(engine: GasolineEngine): Engine

    @Binds
    abstract fun bindEngine(engine: DieselEngine): Engine
}