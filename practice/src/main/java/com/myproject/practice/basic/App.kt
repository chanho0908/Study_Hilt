package com.myproject.practice.basic

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {

    val TAG = App::class.java.simpleName

    @Inject
    lateinit var myName: MyName

    override fun onCreate() {
        super.onCreate()

        Log.d(TAG, "My name is $myName")
    }
}