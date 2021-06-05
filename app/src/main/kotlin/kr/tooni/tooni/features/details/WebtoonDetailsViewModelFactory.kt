/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.features.details

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import kr.tooni.tooni.core.StringKeySet

class WebtoonDetailsViewModelFactory(
    owner: SavedStateRegistryOwner,
    args: Bundle?
) : AbstractSavedStateViewModelFactory(owner, args) {
    
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(WebtoonDetailsViewModel::class.java)) {
            val id = handle.get<Long>(StringKeySet.ID) ?: -1L // same as assistedInject
            return WebtoonDetailsViewModel(webtoonId = id) as T
        } else {
            throw IllegalStateException("$modelClass is Unknown ViewModel class")
        }
    }
}
