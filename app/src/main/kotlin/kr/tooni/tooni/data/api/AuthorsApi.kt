package kr.tooni.tooni.data.api

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.data.response.RecommendAuthorResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthorsApi: Api {
    @GET("api/v1/authors")
    fun getRecommendAuthor() : Single<RecommendAuthorResponse>
}