package com.myproject.practice.sample_map_multibinding

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
class MapMultiBindingModule {

    @Provides
    @IntoMap
    @IntKey(100)
    fun provideIntString1(): String = "백점"

    @Provides
    @IntoMap
    @IntKey(90)
    fun provideIntString2(): String = "구십점"

    @Provides
    @IntoMap
    @AnimalKey(Animal.DOG)
    fun provideDog() = "멍멍이"

    @Provides
    @IntoMap
    @AnimalKey(Animal.CAT)
    fun provideCat() = "고양이"
}