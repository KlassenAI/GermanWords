package com.android.germanwords.data.local_data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.germanwords.domain.word_card.WordCard

@Database(
    version = 1,
    entities = [WordCard::class],
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        const val TAG = "GermanWordsDatabase"
    }

    abstract val wordCardDao: WordCardDao
}