/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.data.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import kr.tooni.tooni.BuildConfig
import kr.tooni.tooni.core.extensions.EMPTY
import kr.tooni.tooni.core.model.User

class PreferenceImpl constructor(
    private val context: Context,
    private val gson: Gson
) : Preference {
    
    private val instance: SharedPreferences
        get() = context.getSharedPreferences(
            BuildConfig.APPLICATION_ID + PREFS_NAME, Context.MODE_PRIVATE
        )
    
    override var uid: String
        get() = instance.getString(USER_ID, String.EMPTY) ?: String.EMPTY
        set(value) {
            instance.edit(commit = true) { putString(USER_ID, value) }
        }
    
    override var user: User
        get() {
            val value = instance.getString(USER, String.EMPTY) ?: String.EMPTY
            return gson.fromJson(value, User::class.java)
        }
        set(value) {
            instance.edit(commit = true) { putString(USER, gson.toJson(value)) }
        }
    
    companion object {
        private const val PREFS_NAME = ".tooni.pref"
        private const val USER_ID = "USER_ID"
        private const val USER = "USER"
    }
}
