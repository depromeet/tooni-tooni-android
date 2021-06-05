/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.core.model

data class Webtoon(
    val id: Long,
    val site: Site,
    val title: String,
    val authors: List<Author>,
    val thumbnail: String,
    val score: Double,
    val genres: List<String>,
    val backgroundColor: BackgroundColor,
    val isComplete: Boolean
) {
    
    val authorFullName: String
        get() = authors.joinToString(" / ") { it.name }
    
    companion object {
        
        val EMPTY = Webtoon(
            id = 0,
            authors = listOf(),
            site = Site.NONE,
            thumbnail = "",
            title = "",
            score = 0.0,
            genres = listOf(),
            backgroundColor = BackgroundColor.NONE,
            isComplete = false
        )
    }
}
