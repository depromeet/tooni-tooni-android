/*
 * Created by Leo on 2021. 05. 22 ..
 */
package kr.tooni.tooni.features.day

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.tooni.tooni.core.WebtoonByDay
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.core.model.WeekDay
import javax.inject.Inject

class WebtoonByDayRepositoryImpl @Inject constructor(
    private val remoteDataSource: WebtoonByDayRemoteDataSource
) : WebtoonByDayRepository {
    
    override fun getWebtoonsAllDay(): Single<WebtoonByDay> {
        val weekDay = WeekDay.values().toList()
        
        return Observable.fromIterable(weekDay)
            .concatMapEager { day ->
                remoteDataSource.getWebtoons(day.value)
                    .map { webtoons -> day to webtoons }
                    .toObservable()
                    .subscribeOn(Schedulers.io())
            }
            .map { pair -> mapOf(pair) }
            .singleOrError()
    }
    
    override fun getWebtoonsByDay(day: String): Single<List<Webtoon>> {
        return remoteDataSource.getWebtoons(day)
    }
}
