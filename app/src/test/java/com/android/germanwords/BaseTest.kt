package com.android.germanwords

import com.android.germanwords.core.di.viewModelModule
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import kotlin.test.AfterTest
import kotlin.test.BeforeTest

abstract class BaseTest: KoinComponent {

    @BeforeTest
    fun setUp() {
        startKoin {
            modules(viewModelModule)
        }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }
}