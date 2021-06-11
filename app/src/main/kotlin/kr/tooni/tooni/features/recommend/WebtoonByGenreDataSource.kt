package kr.tooni.tooni.features.recommend

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.api.ListApi
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

class WebtoonByGenreRemoteDataSource @Inject constructor(
    private val retrofit: Retrofit
) {

    // api call
    fun getWebtoons(genre: String): Single<List<Webtoon>> {
        return retrofit.create(ListApi::class.java).findGenreTop20Webtoons(genre)
            .map { it.data.top20Webtoons }
    }
}
