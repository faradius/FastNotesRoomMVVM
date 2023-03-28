package com.developerscracks.fastnotes.presentation.note_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerscracks.fastnotes.domain.model.Note
import com.developerscracks.fastnotes.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(private val noteRepository: NoteRepository): ViewModel() {

    private var _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList: StateFlow<List<Note>> = _noteList

    //cuando se cree este viewModel junto con el fragmento llamemos a esta lista de notas
    init {
        getNotes()
    }

    fun getNotes(){
        //onEach no esta permitiendo obtener nuesta lista de notas, es propia de las corrutinas flow
        noteRepository.getNotes().onEach {noteList ->
            _noteList.value = noteList
        }.launchIn(viewModelScope) //Le tenemos que definir el alcance o sobre que escope se va ejecutar la corrita
    }
}