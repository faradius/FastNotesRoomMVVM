package com.developerscracks.fastnotes.di

import com.developerscracks.fastnotes.domain.repository.NoteRepository
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
    fun provideNoteRepository() = NoteRepository()

}