/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.core.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kr.tooni.tooni.base.arch.Event
import kr.tooni.tooni.base.arch.EventObserver

inline fun <T> LiveData<Event<T>>.observeEvent(
    lifecycleOwner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
) {
    observe(lifecycleOwner, EventObserver {
        onChanged.invoke(it)
    })
}

inline fun <T> MutableLiveData<Event<T>>.observeEvent(
    lifecycleOwner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
) {
    observe(lifecycleOwner, EventObserver {
        onChanged.invoke(it)
    })
}
