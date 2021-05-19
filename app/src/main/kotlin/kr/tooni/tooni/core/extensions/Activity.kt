/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.core.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import kr.tooni.tooni.base.arch.Event
import kr.tooni.tooni.base.arch.EventObserver

fun <T> AppCompatActivity.observeEvent(
    liveData: LiveData<Event<T>>,
    action: (T) -> Unit
) {
    liveData.observe(this, EventObserver { action(it) })
}
