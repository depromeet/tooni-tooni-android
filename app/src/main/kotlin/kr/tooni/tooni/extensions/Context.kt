/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.extensions

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.getDrawableCompat(@DrawableRes resourceId: Int) = ContextCompat.getDrawable(this, resourceId)
