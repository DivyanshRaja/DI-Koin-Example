package com.example.di_recyclerview

import android.app.Application
import com.example.di_recyclerview.di.module.appModule
import com.example.di_recyclerview.di.module.repoModule
import com.example.di_recyclerview.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    companion object {
        var INSTANCE: MainApplication = MainApplication()
    }
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this@MainApplication
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}