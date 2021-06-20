package kr.tooni.tooni.features.recommend

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon
import javax.inject.Inject

class WebtoonByGenreRepositoryImpl @Inject constructor(
    private val remoteDataSource: WebtoonByGenreRemoteDataSource
) : WebtoonByGenreRepository {

    override fun getWebtoonsByGenre(genre: String): Single<List<Webtoon>> {
        return remoteDataSource.getWebtoons(genre)
    }
}
