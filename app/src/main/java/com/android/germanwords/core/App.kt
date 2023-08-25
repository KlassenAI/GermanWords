package com.android.germanwords.core

import android.app.Application
import com.android.germanwords.core.di.localDataSourceModule
import com.android.germanwords.core.di.localRepositoryModule
import com.android.germanwords.core.di.useCaseModule
import com.android.germanwords.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                localDataSourceModule,
                localRepositoryModule,
                useCaseModule,
                viewModelModule,
            )
        }
    }
}