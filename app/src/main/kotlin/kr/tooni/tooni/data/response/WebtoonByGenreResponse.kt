/*
 * Created by Leo on 2021. 06. 09 ..
 */
package kr.tooni.tooni.data.response

import com.google.gson.annotations.SerializedName
import kr.tooni.tooni.core.model.Webtoons

data class WebtoonByGenreResponse(
    @SerializedName("top20Webtoons")
    val webtoons: Webtoons
) : BaseResponse()
