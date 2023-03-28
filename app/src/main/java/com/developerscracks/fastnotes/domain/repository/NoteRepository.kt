package com.developerscracks.fastnotes.domain.repository

import com.developerscracks.fastnotes.data.data_source.getNoteList
import com.developerscracks.fastnotes.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class NoteRepository {

    fun getNotes(): Flow<List<Note>> = flow {
        val cacheNoteList = getNoteList()
        emit(cacheNoteList)
    }.catch { e ->
        //Recorre todos los elementos en donde se ha presentado algun error
        //Esto utilizado para las bases de datos
        e.printStackTrace()
    }
}