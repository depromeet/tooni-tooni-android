package kr.tooni.tooni.features.search

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.extensions.applySchedulers
import kr.tooni.tooni.core.model.Webtoon
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

    init{
        random()
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

    fun insert(keyword: String){
        recentRepository.insertKeyword(keyword)
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .applySchedulers()
            .subscribe()
            .addDisposable()
    }

    // TODO : 요 함수를 검색전 화면에서 호출하고,
    // TODO : randomWebtoons 를 Activity 에서 observe하고 있다가, adapter.submitList에 넣으면 됩니다!!
    fun random() {
        webtoonSearchRepository.random()
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .applySchedulers()
            .subscribe(randomWebtoons::setValue, Timber::e)
            .addDisposable()
    }
}


