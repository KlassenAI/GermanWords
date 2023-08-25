package com.android.germanwords.data

import com.android.germanwords.core.RequestResult
import com.android.germanwords.core.RequestResult.Success
import com.android.germanwords.data.local_data_source.WordCardDao
import com.android.germanwords.domain.word_card.WordCard

class WordCardLocalRepositoryImpl(
    private val wordCardDao: WordCardDao
): WordCardRepository {

    override suspend fun addWordCard(wordCard: WordCard): RequestResult<Long> {
        return Success(wordCardDao.addWordCard(wordCard))
    }

    override suspend fun updateWordCard(wordCard: WordCard): RequestResult<Unit> {
        return Success(wordCardDao.updateWordCard(wordCard))
    }

    override suspend fun deleteWordCardById(wordCardId: Long): RequestResult<Unit> {
        return Success(wordCardDao.deleteWordCardById(wordCardId))
    }

    override suspend fun getWordCardList(): RequestResult<List<WordCard>> {
        return Success(wordCardDao.getWordCardList())
    }
}