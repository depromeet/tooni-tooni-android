/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.core.model

import com.google.gson.annotations.SerializedName
import kr.tooni.tooni.core.StringKeySet

enum class Site {
    @SerializedName(StringKeySet.NAVER)
    NAVER,
    @SerializedName(StringKeySet.DAUM)
    DAUM,
    @SerializedName(StringKeySet.KAKAO)
    KAKAO,
    @SerializedName(StringKeySet.NONE)
    NONE
}
