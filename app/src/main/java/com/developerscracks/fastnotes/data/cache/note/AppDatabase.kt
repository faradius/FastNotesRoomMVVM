package com.developerscracks.fastnotes.data.cache.note

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getNoteDao():NoteDao

    companion object{
        val DATABASE_NAME = "note_db"
    }
}