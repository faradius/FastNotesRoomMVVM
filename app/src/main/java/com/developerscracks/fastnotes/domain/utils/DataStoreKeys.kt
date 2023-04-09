package com.developerscracks.fastnotes.domain.utils

import androidx.datastore.preferences.core.booleanPreferencesKey

class DataStoreKeys {

    companion object{
        val DARK_MODE_KEY = booleanPreferencesKey("com.developerscracks.fastnotes.DARK_MODE_KEY")
        val LAYOUT_MODE_KEY = booleanPreferencesKey("com.developerscracks.fastnotes.LAYOUT_MODE_KEY")
    }
}