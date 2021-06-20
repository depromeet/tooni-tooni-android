/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.core.model

data class Webtoon(
    val id: Long,
    val site: Site,
    val title: String,
    val summary: String,
    val authors: List<Author>,
    val thumbnail: String,
    val url: String,
    val score: Double, // 플랫폼 평점
    val genres: List<String>, // list ( "스토리", "액션" )
    val weekday: List<WeekDay>,
    val backgroundColor: BackgroundColor, // 웹툰 배경화면
    val isComplete: Boolean // 웹툰 연재중 여부
) {
    
    val authorFullName: String
        get() = authors.joinToString(" / ") { it.name }
    
    val genresConcat: String
        get() = genres.joinToString(" | ")
    
    val roundedScore: String
        get() = String.format("%.2f", score)

    val genresConcat: String
        get() = genres.joinToString(" | ")
    
    companion object {
        
        val EMPTY = Webtoon(
            id = 0,
            authors = listOf(),
            site = Site.NONE,
            thumbnail = "",
            title = "",
            summary = "",
            url = "",
            score = 0.0,
            genres = listOf(),
            weekday = listOf(),
            backgroundColor = BackgroundColor.NONE,
            isComplete = false
        )
    }
}
