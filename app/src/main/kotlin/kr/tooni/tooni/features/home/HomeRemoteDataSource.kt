/*
 * Created by Leo on 2021. 06. 11 ..
 */
package kr.tooni.tooni.features.home

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.core.model.Banner
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.api.HomeApi
import retrofit2.Retrofit
import javax.inject.Inject

class HomeRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {
    
    private val homeApi by lazy {
        retrofit.create(HomeApi::class.java)
    }
    
    fun getMainBanner(): Single<List<Banner>> {
        return homeApi.getHomeDetails().map { it.data.mainBanner }
    }
    
    fun getWeekdayWebtoons(): Single<List<Webtoon>> {
        return homeApi.getHomeDetails().map { it.data.weekdayWebtoons }
    }
    
    fun getTrendingWebtoons(): Single<List<Webtoon>> {
        return homeApi.getHomeDetails().map { it.data.trendingWebtoons }
    }
    
    fun getRecommendAuthors(): Single<List<Author>> {
        return homeApi.getHomeDetails().map { it.data.recommendAuthors }
    }
    
    fun getGenreWebtoons(): Single<List<Webtoon>> {
        return homeApi.getHomeDetails().map { it.data.genreWebtoons }
    }
    
    fun getBingeWatchableWebtoons(): Single<List<Webtoon>> {
        return homeApi.getHomeDetails().map { it.data.bingeWatchableWebtoons }
    }
}
