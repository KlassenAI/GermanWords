package com.android.germanwords.core.di

import androidx.room.Room
import com.android.germanwords.data.WordCardLocalRepositoryImpl
import com.android.germanwords.data.WordCardRepository
import com.android.germanwords.data.local_data_source.AppDatabase
import com.android.germanwords.data.local_data_source.WordCardDao
import com.android.germanwords.domain.use_cases.AddWordCardUseCase
import com.android.germanwords.domain.use_cases.DeleteWordCardByIdUseCase
import com.android.germanwords.domain.use_cases.GetWordCardListUseCase
import com.android.germanwords.domain.use_cases.UpdateWordCardUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.koinApplication
import org.koin.dsl.module

val localDataSourceModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(get(), AppDatabase::class.java, AppDatabase.TAG).build()
    }

    single<WordCardDao> { get<AppDatabase>().wordCardDao }
}

val localRepositoryModule = module {
    single<WordCardRepository> { WordCardLocalRepositoryImpl(get()) }
}

val useCaseModule = module {
    single { AddWordCardUseCase(get()) }
    single { GetWordCardListUseCase(get()) }
    single { UpdateWordCardUseCase(get()) }
    single { DeleteWordCardByIdUseCase(get()) }
}

val viewModelModule = module {
}