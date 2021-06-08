/*
 * Created by Leo on 2021. 06. 09 ..
 */
package kr.tooni.tooni.data.api

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.data.response.HomeResponse
import retrofit2.http.GET

interface HomeApi : Api {

    @GET("api/v1/home")
    fun getHomeDetails(): Single<HomeResponse>
}
