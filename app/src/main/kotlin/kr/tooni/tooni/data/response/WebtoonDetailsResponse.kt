/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.Comment
import kr.tooni.tooni.core.model.Score
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.core.model.WebtoonDetails

data class WebtoonDetailsResponse(
    val data: Spec
) : BaseResponse() {
    
    data class Spec(
        val webtoon: Webtoon,
        val toonieScore: Score,
        val comments: List<Comment>
    ) {
        
        fun toDetails(): WebtoonDetails {
            return WebtoonDetails(
                id = webtoon.id,
                site = webtoon.site,
                title = webtoon.title,
                summary = webtoon.summary,
                authors = webtoon.authors,
                comments = comments,
                thumbnail = webtoon.thumbnail,
                backgroundColor = webtoon.backgroundColor,
                url = webtoon.url,
                score = webtoon.score,
                toonieScore = toonieScore,
                genres = webtoon.genres,
                weekday = webtoon.weekday
            )
        }
    }
}
