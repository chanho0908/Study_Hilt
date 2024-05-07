package com.myproject.practice.sample_qulifier

import javax.inject.Qualifier

@Qualifier
annotation class UserQualifier(val age: Int, val height: Int)
