package kr.tooni.tooni.features.author

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.extensions.applySchedulers
import kr.tooni.tooni.core.model.Authors
import timber.log.Timber
import javax.inject.Inject

class AuthorDetailViewModel @Inject constructor(
    private val authorDetailRepository: AuthorDetailRepository
) : BaseViewModel() {
    private val _authors = MutableLiveData<List<Authors>>()
    val authors: LiveData<List<Authors>>
        get() = _authors

    init{
        authorDetailRepository.getAuthor()
            .applySchedulers()
            .subscribe(_authors::setValue, Timber::e)
            .addDisposable()
    }

}