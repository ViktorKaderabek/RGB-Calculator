package com.example.rgb_picker

import android.app.Application
import com.example.rgb_picker.di.AppModule
import com.example.rgb_picker.di.colorDetailViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf(AppModule, colorDetailViewModel))
        }
    }
}