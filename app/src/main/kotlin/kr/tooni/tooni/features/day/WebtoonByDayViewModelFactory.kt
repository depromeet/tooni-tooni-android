/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.features.day

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import kr.tooni.tooni.core.StringKeySet
import kr.tooni.tooni.core.extensions.EMPTY

class WebtoonByDayViewModelFactory(
    owner: SavedStateRegistryOwner,
    args: Bundle?
) : AbstractSavedStateViewModelFactory(owner, args) {
    
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(WebtoonByDayViewModel::class.java)) {
            val day = handle.get<String>(StringKeySet.DAY) ?: String.EMPTY // same as assistedInject
            return WebtoonByDayViewModel(day = day) as T
        } else {
            throw IllegalStateException("$modelClass is Unknown ViewModel class")
        }
    }
}
