/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.core.extensions

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import kr.tooni.tooni.base.arch.Event
import kr.tooni.tooni.base.arch.EventObserver

fun Fragment.getDrawableCompat(@DrawableRes resourceId: Int): Drawable? {
    return requireContext().getDrawableCompat(resourceId)
}
fun Fragment.getColor(@ColorRes colorId: Int) = ContextCompat.getColor(requireContext(), colorId)

inline fun <T> Fragment.observeEvent(
    liveData: LiveData<Event<T>>,
    crossinline action: (T) -> Unit
) {
    liveData.observe(viewLifecycleOwner, EventObserver { action(it) })
}
