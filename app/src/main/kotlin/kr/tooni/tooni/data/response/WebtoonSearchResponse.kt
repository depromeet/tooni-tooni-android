/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.Webtoon

data class WebtoonSearchResponse(
    val data: WebtoonSearch?
) : BaseResponse() {
    
    data class WebtoonSearch(
        val query: String,
        val webtoons: List<Webtoon>
    )
}
