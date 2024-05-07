package com.myproject.practice.sample_entrypoint

import android.content.Context
import android.util.Log
import dagger.hilt.EntryPoints

class EntryManager {

    fun getEntry(context: Context){
        val entryPoint: MainEntryPoint = EntryPoints.get(context, MainEntryPoint::class.java)
        val result = entryPoint.getEntry()

        Log.d("EntryResult", "entry = $result")
    }
}