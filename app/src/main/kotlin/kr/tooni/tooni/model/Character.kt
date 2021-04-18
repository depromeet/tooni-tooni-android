/*
 * Created by Leo on 2021. 04. 18 ..
 */
package kr.tooni.tooni.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Long
): Parcelable
