package kr.tooni.tooni.features.top20

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon

interface Top20Repository {
    fun getTop20(): Single<List<Webtoon>>
}