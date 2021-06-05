/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.core.model

data class Comment(
    val accountNickName: String,
    val comment: String
) {
    
    companion object {
        
        val EMPTY = Comment(
            accountNickName = "",
            comment = ""
        )
    }
}
