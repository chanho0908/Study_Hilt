package com.myproject.practice.sample_custom_component

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import kotlin.random.Random

@Module
@InstallIn(DialogComponent::class)
class DialogModule {

    @Provides
    fun provideUser(): User{
        return User("chanho")
    }

    @Provides
    @DialogScoped
    fun provideRandomNumber(): Int{
        return Random.nextInt()
    }
}