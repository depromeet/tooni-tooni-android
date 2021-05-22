/*
 * Created by Leo on 2021. 05. 22 ..
 */
package kr.tooni.tooni.features.day

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.WebtoonByDay
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.core.model.WeekDay

interface WebtoonByDayRepository {
    fun getWebtoonsAllDay(): Single<WebtoonByDay>
    fun getWebtoonsByDay(day: String): Single<List<Webtoon>>
}
