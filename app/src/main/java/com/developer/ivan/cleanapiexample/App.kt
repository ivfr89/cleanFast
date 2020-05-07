package com.developer.ivan.cleanapiexample

import android.app.Application
import com.developer.ivan.cleanapiexample.di.appModule
import com.developer.ivan.cleanapiexample.di.dataModule
import com.developer.ivan.cleanapiexample.di.usecasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App(): Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(listOf(dataModule,appModule,usecasesModule))
        }
    }

}