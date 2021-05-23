/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.core.model

data class WebtoonDetails(
    val id: Long,
    val site: Site,
    val title: String,
    val summary: String,
    val authors: List<Author>,
    val comments: List<Comment>,
    val thumbnail: String,
    val url: String,
    val score: Score, // 플랫폼 평점
    val genres: List<String>,
    val weekday: List<WeekDay>
) {
    
    companion object {
        
        val EMPTY = WebtoonDetails(
            id = 0,
            site = Site.NONE,
            title = "",
            summary = "",
            authors = listOf(),
            comments = listOf(),
            thumbnail = "",
            url = "",
            score = Score(
                drawingScore = 0.0,
                storyScore = 0.0,
                totalScore = 0.0
            ),
            genres = listOf(),
            weekday = listOf()
        )
    }
}
