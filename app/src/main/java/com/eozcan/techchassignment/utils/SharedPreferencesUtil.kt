package com.eozcan.techchassignment.utils

import android.content.Context

class SharedPreferencesUtil {
    companion object {
        private const val PREF_FNAME = ".session"
        fun setBoolean(context: Context, key: String, value: Boolean) {
            val sharedPref = context.getSharedPreferences(PREF_FNAME, Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }

        fun getBoolean(context: Context, key: String): Boolean {
            val sharedPref = context.getSharedPreferences(PREF_FNAME, Context.MODE_PRIVATE)
            return sharedPref.getBoolean(key, false)
        }
    }
}