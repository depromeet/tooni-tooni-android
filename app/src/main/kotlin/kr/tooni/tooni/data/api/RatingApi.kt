/*
 * Created by Leo on 2021. 06. 09 ..
 */
package kr.tooni.tooni.data.api

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.data.request.VoteRequest
import kr.tooni.tooni.data.response.UpsertWebtoonResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RatingApi {

    @POST("api/v1/rating/upsert")
    fun upsertWebtoonScore(
        @Body voteRequest: VoteRequest
    ): Single<UpsertWebtoonResponse>
}
