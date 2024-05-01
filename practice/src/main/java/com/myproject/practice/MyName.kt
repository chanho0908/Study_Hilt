package com.myproject.practice

import javax.inject.Inject

class MyName @Inject constructor() {
    override fun toString(): String {
        return "나는 감자다"
    }
}