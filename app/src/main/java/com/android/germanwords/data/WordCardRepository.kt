package com.android.germanwords.data

import com.android.germanwords.core.RequestResult
import com.android.germanwords.domain.word_card.WordCard

interface WordCardRepository {

    suspend fun addWordCard(wordCard: WordCard): RequestResult<Long>

    suspend fun updateWordCard(wordCard: WordCard): RequestResult<Unit>

    suspend fun deleteWordCardById(wordCardId: Long): RequestResult<Unit>

    suspend fun getWordCardList(): RequestResult<List<WordCard>>
}