package com.way.cleanarch.infra.utils

import android.content.Context


class SharedPrefs(context: Context) {
    companion object {
        private const val PREF = "CleanApp"
        private const val PREF_TOKEN = "user_token"
    }

    private val sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)

    fun saveToken(token: String) = put(PREF_TOKEN, token)

    fun getToken(): String = get(PREF_TOKEN, String::class.java)

    fun removeToken() = sharedPreferences.edit().remove(PREF_TOKEN).apply()

    @Suppress("UNCHECKED_CAST")
    private fun <T> get(key: String, clazz: Class<T>): T =
        when (clazz) {
            String::class.java -> sharedPreferences.getString(key, "")
            Boolean::class.java -> sharedPreferences.getBoolean(key, false)
            Float::class.java -> sharedPreferences.getFloat(key, -1f)
            Double::class.java -> sharedPreferences.getFloat(key, -1f)
            Int::class.java -> sharedPreferences.getInt(key, -1)
            Long::class.java -> sharedPreferences.getLong(key, -1L)
            else -> null
        } as T

    private fun <T> put(key: String, data: T) {
        sharedPreferences.edit().apply {
            when (data) {
                is String -> putString(key, data)
                is Boolean -> putBoolean(key, data)
                is Float -> putFloat(key, data)
                is Double -> putFloat(key, data.toFloat())
                is Int -> putInt(key, data)
                is Long -> putLong(key, data)
            }
        }.apply()
    }
}