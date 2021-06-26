/*
 * Created by Leo on 2021. 06. 09 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.core.model.Webtoons

data class WebtoonByAuthorResponse(
    val data: Spec
) : BaseResponse() {
    
    data class Spec(
        val authorName: String,
        val totalWebtoon: Int,
        val webtoons: List<Webtoon>
        )


}
