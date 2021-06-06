/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.data.api

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.data.request.LoginRequest
import kr.tooni.tooni.data.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountApi : Api {
    
    @POST("api/v1/login")
    fun login(
        @Body request: LoginRequest
    ): Single<LoginResponse>
}
