package kr.tooni.tooni.features.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.base.arch.Event
import kr.tooni.tooni.core.extensions.applySchedulers
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.features.day.WebtoonByDayViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WebtoonSearchViewModel @Inject constructor(
    private val recentRepository: WebtoonRecentRepository,
    private val webtoonSearchRepository: WebtoonSearchRepository
) : BaseViewModel() {

    val randomWebtoons = MutableLiveData<List<Webtoon>>()
    val webtoons = MutableLiveData<List<Webtoon>>()
    val keywords = MutableLiveData<List<WebtoonRecentEntity>>()

    private val _action = MutableLiveData<Event<WebtoonSearchViewModel.Action>>()
    val action: LiveData<Event<WebtoonSearchViewModel.Action>>
        get() = _action

    init {
        random()
    }

    sealed class Action {
        data class OnClick(val id: Long) : Action()
    }

    fun search(keyword: String) {
        webtoonSearchRepository.search(keyword)
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .applySchedulers()
            .subscribe(webtoons::setValue, Timber::e)
            .addDisposable()
    }

    fun getAllRecentEntity() {
        recentRepository.getAll()
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .applySchedulers()
            .subscribe(keywords::setValue, Timber::e)
            .addDisposable()
    }

    fun insert(keyword: String) {
        recentRepository.insertKeyword(keyword)
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .applySchedulers()
            .subscribe()
            .addDisposable()
    }

    fun random() {
        webtoonSearchRepository.random()
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .applySchedulers()
            .subscribe(randomWebtoons::setValue, Timber::e)
            .addDisposable()
    }

    fun onWebtoonClicked(id: Long) {
        _action.value = Event(WebtoonSearchViewModel.Action.OnClick(id))
    }
}


