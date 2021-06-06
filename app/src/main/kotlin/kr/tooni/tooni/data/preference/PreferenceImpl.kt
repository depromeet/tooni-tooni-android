/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.data.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import kr.tooni.tooni.BuildConfig
import kr.tooni.tooni.core.extensions.EMPTY

class PreferenceImpl constructor(private val context: Context) : Preference {
    
    private val instance: SharedPreferences
        get() = context.getSharedPreferences(
            BuildConfig.APPLICATION_ID + PREFS_NAME, Context.MODE_PRIVATE
        )
    
    override var uid: String
        get() = instance.getString(USER_ID, String.EMPTY) ?: String.EMPTY
        set(value) {
            instance.edit { putString(USER_ID, value).apply() }
        }
    
    companion object {
        private const val PREFS_NAME = ".tooni.pref"
        private const val USER_ID = "USER_ID"
    }
}
