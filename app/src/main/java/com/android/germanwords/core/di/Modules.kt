package com.android.germanwords.core.di

import com.android.germanwords.SimpleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SimpleViewModel() }
}