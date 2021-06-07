package kr.tooni.tooni.features.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.core.model.WebtoonDetails
import kr.tooni.tooni.features.details.WebtoonDetailsRepository
import kr.tooni.tooni.features.details.WebtoonDetailsRepositoryImpl
import shark.AndroidObjectInspectors
import timber.log.Timber

class WebtoonSearchViewModel(
    private val recentRepository: WebtoonRecentRepository,
    private val webtoonSearchRepository: WebtoonSearchRepository
) : BaseViewModel() {
    val webtoons = MutableLiveData<List<Webtoon>>()
    val keywords = MutableLiveData<List<WebtoonRecentEntity>>()
    fun search(keyword: String) {
        webtoonSearchRepository.search(keyword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                webtoons.value = it
            }, {

            })
            .addDisposable()
    }

    fun getAllRecentEntity() {
        recentRepository.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                keywords.value = it
            }, {

            })
            .addDisposable()
    }
}


