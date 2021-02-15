package com.example.practice6

import android.app.Application
import timber.log.Timber

class MistplayApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}