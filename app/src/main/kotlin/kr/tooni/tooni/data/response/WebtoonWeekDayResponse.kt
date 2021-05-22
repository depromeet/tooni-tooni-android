/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.Webtoon

data class WebtoonWeekDayResponse(
    val data: Webtoons
) : BaseResponse() {
    
    data class Webtoons(
        val webtoons: List<Webtoon>
    )
}
