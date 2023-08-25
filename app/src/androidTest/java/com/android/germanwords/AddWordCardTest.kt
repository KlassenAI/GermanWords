package com.android.germanwords

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.germanwords.core.RequestResult
import com.android.germanwords.data.local_data_source.WordCardDao
import com.android.germanwords.domain.use_cases.AddWordCardUseCase
import com.android.germanwords.domain.word_card.WordCard
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@RunWith(AndroidJUnit4::class)
class AddWordCardTest : KoinComponent {

    private val wordCardDao: WordCardDao by inject()
    private val addWordCard: AddWordCardUseCase by inject()

    @Before
    fun setUp() = runBlocking { wordCardDao.clear() }

    @After
    fun tearDown() = runBlocking { wordCardDao.clear() }

    @Test
    fun addWordCardWithEmptyWordAndTranslateAndGetErrorMessage() {
        val expect = AddWordCardUseCase.ERROR_WORD_AND_TRANSLATE_IS_EMPTY
        val wordCard = WordCard(word = "", translate = "")
        val useCaseResult = runBlocking { addWordCard(wordCard) }
        val actual = (useCaseResult as? RequestResult.Error)?.error?.message
        assertEquals(expect, actual)
    }

    @Test
    fun addWordCardWithEmptyWordAndGetErrorMessage() {
        val expect = AddWordCardUseCase.ERROR_WORD_IS_EMPTY
        val wordCard = WordCard(word = "", translate = "test")
        val useCaseResult = runBlocking { addWordCard(wordCard) }
        val actual = (useCaseResult as? RequestResult.Error)?.error?.message
        assertEquals(expect, actual)
    }

    @Test
    fun addWordCardWithEmptyTranslateAndGetErrorMessage() {
        val expect = AddWordCardUseCase.ERROR_TRANSLATE_IS_EMPTY
        val wordCard = WordCard(word = "test", translate = "")
        val useCaseResult = runBlocking { addWordCard(wordCard) }
        val actual = (useCaseResult as? RequestResult.Error)?.error?.message
        assertEquals(expect, actual)
    }

    @Test
    fun addWordCardAndGetSuccessMessage() {
        val wordCard = WordCard(word = "test", translate = "test")
        val useCaseResult = runBlocking { addWordCard(wordCard) }
        val actual = (useCaseResult as? RequestResult.Success)?.data
        assertNotNull(actual)
    }
}