/*
 * Created by Leo on 2021. 06. 10 ..
 */
package kr.tooni.tooni.features.recommend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.extensions.EMPTY
import kr.tooni.tooni.core.extensions.applySchedulers
import kr.tooni.tooni.core.model.Webtoon
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GenreWebtoonsViewModel @Inject constructor(
    private val webtoonByGenreRepository: WebtoonByGenreRepository,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    
    private val _webtoons = MutableLiveData<List<Webtoon>>()
    val webtoons: LiveData<List<Webtoon>>
        get() = _webtoons
    
    init {
        val genre = savedStateHandle.get<String>("Genre") ?: String.EMPTY
        
        webtoonByGenreRepository.getWebtoonsByGenre(genre)
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .applySchedulers()
            .subscribe(_webtoons::setValue, Timber::e)
            .addDisposable()
    }
}
