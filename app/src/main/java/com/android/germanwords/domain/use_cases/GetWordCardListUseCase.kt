package com.android.germanwords.domain.use_cases

import com.android.germanwords.core.RequestResult
import com.android.germanwords.data.WordCardRepository
import com.android.germanwords.domain.word_card.WordCard

class GetWordCardListUseCase(
    private val wordCardRepository: WordCardRepository
) {

    suspend operator fun invoke(): RequestResult<List<WordCard>> {
        return wordCardRepository.getWordCardList()
    }
}