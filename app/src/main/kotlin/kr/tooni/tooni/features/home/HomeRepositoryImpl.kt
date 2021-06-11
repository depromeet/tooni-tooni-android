/*
 * Created by Leo on 2021. 06. 11 ..
 */
package kr.tooni.tooni.features.home

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.core.model.Banner
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.di.SchedulerProvider
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: HomeRemoteDataSource,
    private val schedulerProvider: SchedulerProvider
) : HomeRepository {
    
    override fun getMainBanner(): Single<List<Banner>> {
        return remoteDataSource.getMainBanner()
            .subscribeOn(schedulerProvider.io())
    }
    
    override fun getWeekdayWebtoons(): Single<List<Webtoon>> {
        return remoteDataSource.getWeekdayWebtoons()
            .subscribeOn(schedulerProvider.io())
    }
    
    override fun getTrendingWebtoons(): Single<List<Webtoon>> {
        return remoteDataSource.getTrendingWebtoons()
            .subscribeOn(schedulerProvider.io())
    }
    
    override fun getRecommendAuthors(): Single<List<Author>> {
        return remoteDataSource.getRecommendAuthors()
            .subscribeOn(schedulerProvider.io())
    }
    
    override fun getGenreWebtoons(): Single<List<Webtoon>> {
        return remoteDataSource.getGenreWebtoons()
            .subscribeOn(schedulerProvider.io())
    }
    
    override fun getBingeWatchableWebtoons(): Single<List<Webtoon>> {
        return remoteDataSource.getBingeWatchableWebtoons()
            .subscribeOn(schedulerProvider.io())
    }
}
