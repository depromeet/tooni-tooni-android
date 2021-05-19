/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.core.model

import com.google.gson.annotations.SerializedName

data class Site(
    val site: Type?,
    val thumbnail: String?
) {
    
    enum class Type {
        @SerializedName("NAVER")
        NAVER,
        @SerializedName("DAUM")
        DAUM,
        @SerializedName("NONE")
        NONE
    }
    
    companion object {
        
        val EMPTY = Site(
            site = Type.NONE,
            thumbnail = null
        )
    }
}
