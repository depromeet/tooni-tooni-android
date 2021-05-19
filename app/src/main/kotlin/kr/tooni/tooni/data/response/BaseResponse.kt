/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.data.response

import com.google.gson.annotations.SerializedName

abstract class BaseResponse {
    val status: Status? = null
    val message: String? = null
    
    enum class Status {
        @SerializedName("OK")
        OK,
        
        @SerializedName("CLIENT_ERROR")
        CLIENT_ERROR,
        
        @SerializedName("SERVER_ERROR")
        SERVER_ERROR
    }
}
