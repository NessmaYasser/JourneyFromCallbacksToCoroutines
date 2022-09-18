package com.example.journeyfromcallbackstocoroutines

import android.app.Application
import com.example.journeyfromcallbackstocoroutines.data.remote.ClientServiceFactory
import com.example.journeyfromcallbackstocoroutines.di.appModule
import org.koin.android.ext.android.startKoin

class MyApp(): Application() {

    companion object{
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this@MyApp, listOf(appModule))
    }

}