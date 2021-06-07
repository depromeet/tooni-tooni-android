package kr.tooni.tooni.features.search

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.ApiProvider
import kr.tooni.tooni.data.api.ListApi

class WebtoonSearchRepository(private val apiProvider: ApiProvider = ApiProvider) {

    fun search(keyword: String): Single<List<Webtoon>> {
        val api = apiProvider.create(ListApi::class.java)
        return api.search(keyword).map {
            it.data.webtoons
        }
    }

}