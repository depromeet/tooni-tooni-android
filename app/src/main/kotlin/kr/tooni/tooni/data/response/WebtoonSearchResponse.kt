/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.Webtoon

data class WebtoonSearchResponse(
    val data: Spec
) : BaseResponse() {
    
    data class Spec(
        val query: String,
        val webtoons: List<Webtoon>
    )
}
