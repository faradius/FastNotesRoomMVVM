package com.developerscracks.fastnotes.domain.repository

import com.developerscracks.fastnotes.data.cache.note.NoteDao
import com.developerscracks.fastnotes.data.cache.note.toNote
import com.developerscracks.fastnotes.data.cache.note.toNoteEntity
import com.developerscracks.fastnotes.data.data_source.getNoteList
import com.developerscracks.fastnotes.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class NoteRepository(private val noteDao: NoteDao) {

    //Retorna un booleano para si fue registrada de forma correcta o no
    fun insertNote(note: Note): Flow<Boolean> = flow {
        noteDao.insertNote(note.toNoteEntity())

        emit(true)
    }.catch { e ->
        e.printStackTrace()
    }

    fun getNoteById(noteId: String): Flow<Note?> = flow {
        val note = noteDao.getNoteById(noteId)?.toNote()

        emit(note)
    }.catch { e ->
        e.printStackTrace()
    }

    fun getNotes(query: String): Flow<List<Note>> = flow {

        val cacheNoteList = noteDao.getNotes(query).map { it.toNote() }
        emit(cacheNoteList)

    }.catch { e ->
        //Recorre todos los elementos en donde se ha presentado algun error
        //Esto utilizado para las bases de datos
        e.printStackTrace()
    }
}