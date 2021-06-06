/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.data.preference

import android.content.SharedPreferences

interface Preference {
    fun getInstance(): SharedPreferences
    var uid: String
}
