/*
 * Created by Leo on 2021. 05. 22 ..
 */
package kr.tooni.tooni.features.day

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.ApiProvider
import kr.tooni.tooni.data.api.ListApi

class WebtoonByDayRemoteDataSource constructor(private val apiProvider: ApiProvider = ApiProvider) {
    
    fun getWebtoons(day: String): Single<List<Webtoon>> {
        return apiProvider.create(ListApi::class.java).getWebtoonsByDay(day)
            .map { it.data.webtoons }
    }
}
