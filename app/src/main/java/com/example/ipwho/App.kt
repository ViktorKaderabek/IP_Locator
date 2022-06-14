package com.example.ipwho

import android.app.Application
import com.example.ipwho.di.AppModule
import com.example.ipwho.di.ipByIpVm
import com.example.ipwho.di.myIpInfoVm
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(AppModule, myIpInfoVm, ipByIpVm))
        }
    }
}