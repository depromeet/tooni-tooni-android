/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.core.extensions

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

fun showSnackbar(
    view: View,
    message: CharSequence,
    duration: Int = Snackbar.LENGTH_SHORT,
    anchor: View? = null
) {
    return Snackbar.make(view, message, duration)
        .setAnchorView(anchor)
        .show()
}

fun showSnackbar(
    view: View,
    @StringRes resId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
    anchor: View? = null
) {
    return showSnackbar(view, view.context.getString(resId), duration, anchor)
}
