/*
 * Created by Leo on 2021. 06. 09 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.Webtoon

data class WebtoonByGenreResponse(
    val data: Spec
) : BaseResponse() {
    
    data class Spec(
        val top20Webtoons: List<Webtoon>
    )
}
