package com.developerscracks.fastnotes.presentation.note_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerscracks.fastnotes.R
import com.developerscracks.fastnotes.domain.model.Note
import com.developerscracks.fastnotes.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(private val noteRepository: NoteRepository):ViewModel(){
    private var _selectedColor = MutableStateFlow(R.color.app_bg_color)
    val selectedColor: StateFlow<Int> = _selectedColor

    private var _note = MutableStateFlow<Note?>(null)
    val note: StateFlow<Note?> = _note

    private var _noteHasBeenModified = MutableStateFlow(false)
    val noteHasBeenModified: StateFlow<Boolean> = _noteHasBeenModified

    fun updateNoteColor(newSelectedColor: Int){
        _selectedColor.value = newSelectedColor
    }

    fun saveNoteChanges(title:String, content: String){
        if (_note.value == null){
            saveNewNote(title, content)
        }else{
            updateNote(title, content)
        }
    }

    private fun updateNote(title: String, content: String) {

    }

    private fun saveNewNote(title: String, content: String) {

        if (title.isEmpty() && content.isEmpty()){
            _noteHasBeenModified.value = false
            return //Esto es para que ya no siga haciendo las demas lineas de codigo
        }

        val note = Note(
            title = title,
            content = content,
            color = _selectedColor.value
        )

        noteRepository.insertNote(note).onEach {
            _noteHasBeenModified.value = true
        }.launchIn(viewModelScope)
    }
}