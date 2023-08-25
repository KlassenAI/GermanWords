package com.android.germanwords

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.germanwords.core.RequestResult
import com.android.germanwords.data.local_data_source.WordCardDao
import com.android.germanwords.domain.use_cases.AddWordCardUseCase
import com.android.germanwords.domain.use_cases.DeleteWordCardByIdUseCase
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
class DeleteWordCardTest : KoinComponent {

    companion object {
        private const val WORD_CARD_ID = 1L
        private const val WORD_CARD_WORD = "word"
        private const val WORD_CARD_TRANSLATE = "translate"
    }

    private val wordCardDao: WordCardDao by inject()
    private val deleteWordCardById: DeleteWordCardByIdUseCase by inject()

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
    fun deleteWordCardByIdAndGetSuccessMessage() {
        val useCaseResult = runBlocking { deleteWordCardById(WORD_CARD_ID) }
        val actual = (useCaseResult as? RequestResult.Success)?.data
        assertNotNull(actual)
    }
}