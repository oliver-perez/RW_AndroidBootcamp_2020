@file:Suppress("DEPRECATION")

package com.oliverperez.blockbusterchallenge.DataManagers

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.oliverperez.blockbusterchallenge.Activities.MainActivity

object LoginPrefs {

    private const val KEY_USER_LOGGED = "KEY_USER_LOGGED"

    fun defaultPrefs(context: Context): SharedPreferences
            = PreferenceManager.getDefaultSharedPreferences(context)

    fun saveUserLoginStatus(logged: Boolean, context: Context) {
        val editor = defaultPrefs(context).edit()
        editor.putBoolean(KEY_USER_LOGGED, logged).apply()
    }

    fun isUserLoggedIn(context: Context): Boolean = defaultPrefs(context).getBoolean(KEY_USER_LOGGED, false)
}