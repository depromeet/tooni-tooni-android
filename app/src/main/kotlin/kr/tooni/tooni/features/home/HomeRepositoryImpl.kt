/*
 * Created by Leo on 2021. 06. 11 ..
 */
package kr.tooni.tooni.features.home

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.core.model.Banner
import kr.tooni.tooni.core.model.Webtoon
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    
    override fun getMainBanner(): Single<List<Banner>> {
        return remoteDataSource.getMainBanner()
    }
    
    override fun getWeekdayWebtoons(): Single<List<Webtoon>> {
        return remoteDataSource.getWeekdayWebtoons()
    }
    
    override fun getTrendingWebtoons(): Single<List<Webtoon>> {
        return remoteDataSource.getTrendingWebtoons()
    }
    
    override fun getRecommendAuthors(): Single<List<Author>> {
        return remoteDataSource.getRecommendAuthors()
    }
    
    override fun getGenreWebtoons(): Single<List<Webtoon>> {
        return remoteDataSource.getGenreWebtoons()
    }
    
    override fun getBingeWatchableWebtoons(): Single<List<Webtoon>> {
        return remoteDataSource.getBingeWatchableWebtoons()
    }
}
