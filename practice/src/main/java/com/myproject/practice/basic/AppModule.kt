package com.myproject.practice.basic

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyName(): MyName {
        Log.d("AppModule", " ProvidesMyName 호출")
        return MyName()
    }
}