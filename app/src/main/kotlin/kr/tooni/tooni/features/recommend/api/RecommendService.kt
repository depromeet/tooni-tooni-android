package kr.tooni.tooni.features.recommend.api

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.data.response.WebtoonByGenreResponse
import kr.tooni.tooni.features.recommend.data.WebtoonByGenre
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

@Deprecated("사용하지 않음")
interface RecommendService {

    @GET("/api/v1/webtoons/{genre}")
    suspend fun findGenreTop20Webtoons(
        @Path("genre") genre: String
    ): Response<WebtoonByGenre>

//    @GET("api/v1/webtoons/{genre}")
//    fun findGenreTop20Webtoons(
//        @Path("genre") genre: String
//    ): Single<WebtoonByGenreResponse>

}
