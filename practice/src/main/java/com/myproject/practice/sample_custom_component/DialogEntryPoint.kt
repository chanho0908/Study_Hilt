package com.myproject.practice.sample_custom_component

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import java.time.LocalDateTime

@EntryPoint
@InstallIn(DialogComponent::class)
interface DialogEntryPoint {

    fun getUser(): User
    fun getRandomNumber(): Int
    fun getLocalDateTime(): LocalDateTime
}