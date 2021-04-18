/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.extensions

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Context.getDrawableCompat(@DrawableRes resourceId: Int) = ContextCompat.getDrawable(this, resourceId)
fun Fragment.getDrawableCompat(@DrawableRes resourceId: Int) = requireContext().getDrawableCompat(resourceId)

fun Fragment.getColor(@ColorRes colorId: Int) = ContextCompat.getColor(requireContext(), colorId)
