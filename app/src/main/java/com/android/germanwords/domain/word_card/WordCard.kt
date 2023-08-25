package com.android.germanwords.domain.word_card

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordCard(
    @PrimaryKey
    val id: Long = 0,
    val word: String = "",
    val translate: String = ""
)
