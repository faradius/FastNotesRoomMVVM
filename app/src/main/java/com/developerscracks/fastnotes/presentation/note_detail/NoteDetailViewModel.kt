package com.developerscracks.fastnotes.presentation.note_detail

import androidx.lifecycle.ViewModel
import com.developerscracks.fastnotes.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor():ViewModel(){
    private var _selectedColor = MutableStateFlow(R.color.app_bg_color)
    val selectedColor: StateFlow<Int> = _selectedColor

    fun updateNoteColor(newSelectedColor: Int){
        _selectedColor.value = newSelectedColor
    }
}