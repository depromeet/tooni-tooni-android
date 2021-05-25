/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.core.extensions

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

fun Int.px() = (this * Resources.getSystem().displayMetrics.density).toInt()
fun Int.px(context: Context, dp: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)
