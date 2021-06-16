package kr.tooni.tooni.features.recommend

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.response.WebtoonByGenreResponse

interface WebtoonByGenreRepository {
    fun getWebtoonsByGenre(genre: String): Single<List<Webtoon>>
}
