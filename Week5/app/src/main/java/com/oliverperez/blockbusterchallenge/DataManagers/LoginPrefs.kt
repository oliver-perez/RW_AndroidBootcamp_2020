@file:Suppress("DEPRECATION")

package com.oliverperez.blockbusterchallenge.DataManagers

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.oliverperez.blockbusterchallenge.Activities.MainActivity
import com.oliverperez.blockbusterchallenge.app.BlockbusterApplication

object LoginPrefs {

    private const val KEY_USER_LOGGED = "KEY_USER_LOGGED"

    private fun defaultPrefs(): SharedPreferences
            = PreferenceManager.getDefaultSharedPreferences(BlockbusterApplication.getAppContext())

    fun saveUserLoginStatus(logged: Boolean) {
        val editor = defaultPrefs().edit()
        editor.putBoolean(KEY_USER_LOGGED, logged).apply()
    }

    fun isUserLoggedIn(): Boolean = defaultPrefs().getBoolean(KEY_USER_LOGGED, false)
}