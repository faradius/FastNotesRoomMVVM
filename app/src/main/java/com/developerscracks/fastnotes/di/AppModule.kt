package com.developerscracks.fastnotes.di

import com.developerscracks.fastnotes.R
import com.developerscracks.fastnotes.domain.repository.NoteRepository
import com.developerscracks.fastnotes.presentation.note_detail.ColorSelectorAdapter
import com.developerscracks.fastnotes.presentation.note_list.NoteListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteListAdapter() = NoteListAdapter()

    @Provides
    @Singleton
    fun provideColorSelectorAdapter() = ColorSelectorAdapter(
        listOf(
            R.color.app_bg_color,
            R.color.red001,
            R.color.pink002,
            R.color.orange003,
            R.color.orange004,
            R.color.yellow005,
            R.color.green006,
            R.color.green007,
            R.color.green008,
            R.color.blue009,
            R.color.blue010,
            R.color.purple011
        )
    )

    @Provides
    @Singleton
    fun provideNoteRepository() = NoteRepository()

}