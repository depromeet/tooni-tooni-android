/*
 * Created by Leo on 2021. 04. 18 ..
 */
package kr.tooni.tooni.data.api

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.data.response.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MortyApi : Api {
    
    @GET("api/character/")
    fun getAllCharacters(
        @Query("page") page: Int? = null
    ): Single<CharactersResponse>
}
