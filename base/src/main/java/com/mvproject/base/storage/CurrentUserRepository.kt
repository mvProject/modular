package com.mvproject.base.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

private const val USER_LOGGED: String = "user_logged"

class CurrentUserRepository(context: Context) {
    private val testPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)


    fun setUserLogged(user: String?) {
        user?.let {
            val editor = testPreferences.edit()
            editor.putString(USER_LOGGED, it)
            editor.apply()
        }
    }

    fun isUserLogged(): String {
        return testPreferences.getString(USER_LOGGED, "") ?: ""
    }
}