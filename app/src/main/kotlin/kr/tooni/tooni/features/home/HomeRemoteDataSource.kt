/*
 * Created by Leo on 2021. 06. 11 ..
 */
package kr.tooni.tooni.features.home

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.SingleSubject
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.core.model.Banner
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.api.HomeApi
import kr.tooni.tooni.data.response.HomeResponse
import kr.tooni.tooni.di.SchedulersProvider
import retrofit2.Retrofit
import timber.log.Timber
import javax.inject.Inject

class HomeRemoteDataSource @Inject constructor(
    private val retrofit: Retrofit,
    private val schedulersProvider: SchedulersProvider
) {
    
    private val home = SingleSubject.create<HomeResponse>()
    
    init {
        retrofit.create(HomeApi::class.java).getHomeDetails()
            .subscribeOn(schedulersProvider.io())
            .subscribe(home::onSuccess, Timber::e)
    }
    
    fun getMainBanner(): Single<List<Banner>> {
        return home.map { it.data.mainBanner }
    }
    
    fun getWeekdayWebtoons(): Single<List<Webtoon>> {
        return home.map { it.data.weekdayWebtoons }
    }
    
    fun getTrendingWebtoons(): Single<List<Webtoon>> {
        return home.map { it.data.trendingWebtoons }
    }
    
    fun getRecommendAuthors(): Single<List<Author>> {
        return home.map { it.data.recommendAuthors }
    }
    
    fun getGenreWebtoons(): Single<List<Webtoon>> {
        return home.map { it.data.genreWebtoons }
    }
    
    fun getBingeWatchableWebtoons(): Single<List<Webtoon>> {
        return home.map { it.data.bingeWatchableWebtoons }
    }
}
