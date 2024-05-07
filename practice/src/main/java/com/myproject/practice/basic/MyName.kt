package com.myproject.practice.basic

import java.util.UUID

class MyName{

    private val uuid = UUID.randomUUID()

    override fun toString(): String {
        return uuid.toString()
    }
}