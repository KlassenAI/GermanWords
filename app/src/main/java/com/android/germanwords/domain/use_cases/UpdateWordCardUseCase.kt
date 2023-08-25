package com.android.germanwords.domain.use_cases

import com.android.germanwords.core.RequestResult
import com.android.germanwords.data.WordCardRepository
import com.android.germanwords.domain.word_card.WordCard

class UpdateWordCardUseCase(
    private val wordCardRepository: WordCardRepository
) {

    companion object {
        const val ERROR_WORD_IS_EMPTY = "word is empty"
        const val ERROR_TRANSLATE_IS_EMPTY = "translate is empty"
        const val ERROR_WORD_AND_TRANSLATE_IS_EMPTY = "word and translate are empty"
    }

    suspend operator fun invoke(wordCard: WordCard): RequestResult<Unit> {
        val isWordEmpty = wordCard.word.isEmpty()
        val isTranslateEmpty = wordCard.translate.isEmpty()
        if (isWordEmpty && isTranslateEmpty) {
            return RequestResult.Error(Error(ERROR_WORD_AND_TRANSLATE_IS_EMPTY))
        }
        if (isWordEmpty) {
            return RequestResult.Error(Error(ERROR_WORD_IS_EMPTY))
        }
        if (isTranslateEmpty) {
            return RequestResult.Error(Error(ERROR_TRANSLATE_IS_EMPTY))
        }
        return wordCardRepository.updateWordCard(wordCard)
    }
}