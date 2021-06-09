package kr.tooni.tooni.features.recommend

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.api.ListApi
import kr.tooni.tooni.data.response.WebtoonByGenreResponse
import javax.inject.Inject

class WebtoonByGenreRepositoryImpl @Inject constructor(
    private val remoteDataSource: WebtoonByGenreRemoteDataSource
) : WebtoonByGenreRepository {
    
//    override fun getWebtoonsAllGenre(): Single<List<Webtoon>> {
//        val genres = listOf("일상", "판타지", "액션", "드라마", "순정")
//
//        return Observable.fromIterable(genres)
//            .concatMapEager { genre ->
//                remoteDataSource.getWebtoons(genre)
//                    .map{
//
//                    }
//                    .toObservable()
//                    .subscribeOn(Schedulers.io())
//            }
//            .singleOrError()
//    }

    override fun getWebtoonsByGenre(genre: String): Single<List<Webtoon>> {
        return remoteDataSource.getWebtoons(genre)
    }
}
