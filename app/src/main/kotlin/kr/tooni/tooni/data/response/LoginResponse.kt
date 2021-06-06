/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.data.response

data class LoginResponse(
    val data: Spec
) : BaseResponse() {
    
    data class Spec(val nickname: String)
}
