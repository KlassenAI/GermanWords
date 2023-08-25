package com.android.germanwords.data.local_data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.android.germanwords.domain.word_card.WordCard

@Dao
interface WordCardDao {

    @Insert
    suspend fun addWordCard(wordCard: WordCard): Long

    @Update
    suspend fun updateWordCard(wordCard: WordCard)

    @Query("DELETE FROM wordcard WHERE id = :wordCardId")
    suspend fun deleteWordCardById(wordCardId: Long)

    @Query("SELECT * FROM wordcard")
    suspend fun getWordCardList(): List<WordCard>

    @Query("DELETE FROM wordcard")
    suspend fun clear()
}