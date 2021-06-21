package kr.tooni.tooni.features.top20

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.extensions.applySchedulers
import kr.tooni.tooni.core.model.Webtoon
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class Top20ViewModel @Inject constructor(
    private val top20Repository: Top20Repository,
    private val sevedStateHandle: SavedStateHandle
) : BaseViewModel() {
    private val _webtoons = MutableLiveData<List<Webtoon>>()
    val webtoons: LiveData<List<Webtoon>> get() = _webtoons

    init {
        top20Repository.getTop20()
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .applySchedulers()
            .subscribe(_webtoons::setValue, Timber::e)
            .addDisposable()
    }
}