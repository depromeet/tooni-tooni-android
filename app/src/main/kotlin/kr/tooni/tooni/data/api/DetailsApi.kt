/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.data.api

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.data.response.WebtoonDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailsApi : Api {
    
    @GET("api/v1/webtoons/detail")
    fun getWebtoonDetails(
        @Query("id") id: Long
    ): Single<WebtoonDetailsResponse>
}
