/*
 * Created by Leo on 2021. 05. 22 ..
 */
package kr.tooni.tooni.features.day

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.api.ListApi
import javax.inject.Inject

class WebtoonByDayRemoteDataSource @Inject constructor(
    private val listApi: ListApi
) {
    
    fun getWebtoons(day: String): Single<List<Webtoon>> {
        return listApi.getWebtoonsByDay(day)
            .map { it.data.webtoons }
    }
}
