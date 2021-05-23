/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.features.day

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.base.arch.Event
import kr.tooni.tooni.core.model.Webtoon
import timber.log.Timber

class WebtoonByDayViewModel constructor(
    day: String, // inject from savedStateHandle
    private val webtoonByDayRepository: WebtoonByDayRepository = WebtoonByDayRepositoryImpl()
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
