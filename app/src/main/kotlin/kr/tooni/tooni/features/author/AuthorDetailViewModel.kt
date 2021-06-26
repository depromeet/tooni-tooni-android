package kr.tooni.tooni.features.author

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.extensions.applySchedulers
import kr.tooni.tooni.core.model.Authors
import kr.tooni.tooni.core.model.Webtoon
import timber.log.Timber
import javax.inject.Inject

class AuthorDetailViewModel @Inject constructor(
    private val authorDetailRepository: AuthorDetailRepository
) : BaseViewModel() {
    private val _webtoons = MutableLiveData<List<Webtoon>>()
    val webtoons: LiveData<List<Webtoon>>
        get() = _webtoons

    init{
        authorDetailRepository.getAuthor()
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .applySchedulers()
            .subscribe(_webtoons::setValue, Timber::e)
            .addDisposable()
    }

}