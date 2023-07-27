package com.example.androidsuperpoderes

import android.app.Application
import com.example.androidsuperpoderes.di.dataModule
import com.example.androidsuperpoderes.di.domainModule
import com.example.androidsuperpoderes.di.presentationModule
import org.koin.core.logger.Level
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class SuperHeroApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@SuperHeroApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}