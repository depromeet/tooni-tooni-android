/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.data.api

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.data.response.WebtoonSearchResponse
import kr.tooni.tooni.data.response.WebtoonWeekDayResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ListApi : Api {

    @GET("api/v1/webtoons/search")
    fun search(
        @Query("query") query: String
    ): Single<WebtoonSearchResponse>
    
    @GET("api/v1/webtoons/weekday/{weekday}")
    fun getWebtoonsByDay(
        @Path("weekday") weekday: String
    ): Single<WebtoonWeekDayResponse>
}
