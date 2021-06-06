/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.features.day

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.base.arch.Event
import kr.tooni.tooni.core.StringKeySet
import kr.tooni.tooni.core.extensions.EMPTY
import kr.tooni.tooni.core.model.Webtoon
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WebtoonByDayViewModel @Inject constructor(
    private val webtoonByDayRepository: WebtoonByDayRepository,
    handle: SavedStateHandle
) : BaseViewModel() {
    
    sealed class Action {
        data class WebtoonClick(val id: Long) : Action()
    }
    
    private val _webtoons = MutableLiveData<List<Webtoon>>()
    val webtoons: LiveData<List<Webtoon>>
        get() = _webtoons
    
    private val _action = MutableLiveData<Event<Action>>()
    val action: LiveData<Event<Action>>
        get() = _action
    
    init {
        val day: String = handle.get<String>(StringKeySet.DAY) ?: String.EMPTY
        
        webtoonByDayRepository.getWebtoonsByDay(day)
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(_webtoons::setValue, Timber::e)
            .addDisposable()
    }
    
    fun onWebtoonClicked(id: Long) {
        _action.value = Event(Action.WebtoonClick(id))
    }
}
