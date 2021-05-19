/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.Site
import kr.tooni.tooni.core.model.Webtoon

data class WebtoonWeekDayResponse(
    val data: WebtoonWeekDay
) : BaseResponse() {
    
    data class WebtoonWeekDay(
        val sites: List<Site>,
        val webtoons: List<Webtoon>
    )
}
