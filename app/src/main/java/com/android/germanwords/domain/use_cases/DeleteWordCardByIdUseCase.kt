package com.android.germanwords.domain.use_cases

import com.android.germanwords.core.RequestResult
import com.android.germanwords.data.WordCardRepository

class DeleteWordCardByIdUseCase(
    private val wordCardRepository: WordCardRepository
) {

    suspend operator fun invoke(wordCardId: Long): RequestResult<Unit> {
        return wordCardRepository.deleteWordCardById(wordCardId)
    }
}