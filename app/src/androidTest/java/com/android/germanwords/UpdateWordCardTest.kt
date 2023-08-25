package com.android.germanwords

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.germanwords.core.RequestResult
import com.android.germanwords.data.local_data_source.WordCardDao
import com.android.germanwords.domain.use_cases.AddWordCardUseCase
import com.android.germanwords.domain.use_cases.UpdateWordCardUseCase
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
class UpdateWordCardTest : KoinComponent {

    companion object {
        private const val WORD_CARD_ID = 1L
        private const val WORD_CARD_WORD = "word"
        private const val WORD_CARD_TRANSLATE = "translate"
        private const val WORD_CARD_WORD_UPDATED = "word_updated"
        private const val WORD_CARD_TRANSLATE_UPDATED = "translate_updated"
    }

    private val wordCardDao: WordCardDao by inject()
    private val updateWordCard: UpdateWordCardUseCase by inject()

    @Before
    fun setUp(): Unit = runBlocking {
        wordCardDao.clear()
        wordCardDao.addWordCard(
            WordCard(
                id = WORD_CARD_ID,
                word = WORD_CARD_WORD,
                translate = WORD_CARD_TRANSLATE
            )
        )
    }


    @After
    fun tearDown() = runBlocking { wordCardDao.clear() }

    @Test
    fun updateWordCardWithEmptyWordAndTranslateAndGetErrorMessage() {
        val expect = UpdateWordCardUseCase.ERROR_WORD_AND_TRANSLATE_IS_EMPTY
        val wordCard = WordCard(id = WORD_CARD_ID, word = "", translate = "")
        val useCaseResult = runBlocking { updateWordCard(wordCard) }
        val actual = (useCaseResult as? RequestResult.Error)?.error?.message
        assertEquals(expect, actual)
    }

    @Test
    fun updateWordCardWithEmptyWordAndGetErrorMessage() {
        val expect = UpdateWordCardUseCase.ERROR_WORD_IS_EMPTY
        val wordCard = WordCard(
            id = WORD_CARD_ID,
            word = "",
            translate = WORD_CARD_TRANSLATE_UPDATED
        )
        val useCaseResult = runBlocking { updateWordCard(wordCard) }
        val actual = (useCaseResult as? RequestResult.Error)?.error?.message
        assertEquals(expect, actual)
    }

    @Test
    fun updateWordCardWithEmptyTranslateAndGetErrorMessage() {
        val expect = UpdateWordCardUseCase.ERROR_TRANSLATE_IS_EMPTY
        val wordCard = WordCard(
            id = WORD_CARD_ID,
            word = WORD_CARD_WORD_UPDATED,
            translate = ""
        )
        val useCaseResult = runBlocking { updateWordCard(wordCard) }
        val actual = (useCaseResult as? RequestResult.Error)?.error?.message
        assertEquals(expect, actual)
    }

    @Test
    fun updateWordCardAndGetSuccessMessage() {
        val wordCard = WordCard(
            id = WORD_CARD_ID,
            word = WORD_CARD_WORD_UPDATED,
            translate = WORD_CARD_TRANSLATE_UPDATED
        )
        val useCaseResult = runBlocking { updateWordCard(wordCard) }
        val actual = (useCaseResult as? RequestResult.Success)?.data
        assertNotNull(actual)
    }
}