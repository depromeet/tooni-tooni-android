package kr.tooni.tooni.features.recommend

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.api.ListApi
import javax.inject.Inject

class WebtoonByGenreRemoteDataSource @Inject constructor(
    private val listApi: ListApi
) {

    // api call
    fun getWebtoons(genre: String): Single<List<Webtoon>> {
        return listApi.findGenreTop20Webtoons(genre)
            .map { it.webtoons.webtoons }
    }
}
