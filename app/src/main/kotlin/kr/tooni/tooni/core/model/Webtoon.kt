/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.core.model

data class Webtoon(
    val id: Long,
    val site: String,
    val title: String,
    val authors: List<Author>,
    val thumbnail: String,
    val score: Double,
    val genres: List<String>,
    val backgroundColor: WebtoonBackgroundColor,
    val isComplete: Boolean
) {
    
    companion object {
        
        val EMPTY = Webtoon(
            id = 0,
            authors = listOf(),
            site = "",
            thumbnail = "",
            title = "",
            score = 0.0,
            genres = listOf(),
            backgroundColor = WebtoonBackgroundColor.NONE,
            isComplete = false
        )
    }
}
