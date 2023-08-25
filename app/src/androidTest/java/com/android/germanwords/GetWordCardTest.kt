package com.android.germanwords

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.germanwords.core.RequestResult
import com.android.germanwords.data.local_data_source.WordCardDao
import com.android.germanwords.domain.use_cases.GetWordCardListUseCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@RunWith(AndroidJUnit4::class)
class GetWordCardTest : KoinComponent {

    private val wordCardDao: WordCardDao by inject()
    private val getWordCardList: GetWordCardListUseCase by inject()

    @Before
    fun setUp() = runBlocking { wordCardDao.clear() }

    @After
    fun tearDown() = runBlocking { wordCardDao.clear() }

    @Test
    fun getWordCardListAndItsEmpty() {
        val expect = 0
        val result = runBlocking { getWordCardList() }
        val actual = (result as? RequestResult.Success)?.data?.size
        assertEquals("$expect $actual", expect, actual)
    }
}