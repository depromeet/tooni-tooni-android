/*
 * Created by Leo on 2021. 06. 11 ..
 */
package kr.tooni.tooni.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.core.model.Banner
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.di.SchedulersProvider
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val schedulersProvider: SchedulersProvider
) : BaseViewModel() {
    
    data class State(
        val mainBanner: List<Banner>, // 상단 배너
        val weekdayWebtoons: List<Webtoon>, // 요일별 웹툰 리스트
        val trendingWebtoons: List<Webtoon>, // 인기급상승 웹툰 리스트
        val recommendAuthors: List<Author>, // 추천 작가 리스트
        val genreWebtoons: List<Webtoon>, // 장르별 웹툰 리스트
        val bingeWatchableWebtoons: List<Webtoon> // 몰아보기 좋은 웹툰 리스트
    )
    
    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state
    
    init {
        Single.zip(
            homeRepository.getMainBanner(),
            homeRepository.getWeekdayWebtoons(),
            homeRepository.getTrendingWebtoons(),
            homeRepository.getRecommendAuthors(),
            homeRepository.getGenreWebtoons(),
            homeRepository.getBingeWatchableWebtoons(),
            ::State
        )
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .observeOn(schedulersProvider.main())
            .subscribe(_state::setValue, Timber::e)
            .addDisposable()
    }
}
