/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.core.model

data class Author(
    val id: Long,
    val name: String,
) {
    
    companion object {
        
        val EMPTY = Author(
            id = 0,
            name = ""
        )
    }
}
