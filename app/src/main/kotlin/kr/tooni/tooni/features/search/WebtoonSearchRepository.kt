package kr.tooni.tooni.features.search

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.api.ListApi
import javax.inject.Inject

class WebtoonSearchRepository @Inject constructor(
    private val listApi: ListApi
) {
    
    fun search(keyword: String): Single<List<Webtoon>> {
        return listApi.search(keyword).map {
            it.data.webtoons
        }
    }
}
