/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.core.model

data class Webtoon(
    val id: Long,
    val authors: List<Author>,
    val site: Site,
    val thumbnail: String,
    val title: String
) {
    
    companion object {
        
        val EMPTY = Webtoon(
            id = 0,
            authors = listOf(),
            site = Site(
                site = null,
                thumbnail = null
            ),
            thumbnail = "",
            title = ""
        )
    }
}
