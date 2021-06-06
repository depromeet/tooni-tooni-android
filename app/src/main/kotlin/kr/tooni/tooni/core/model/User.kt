/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.core.model

data class User(
    val accountId: Long,
    val nickname: String,
    val profileImage: String
) {
    
    companion object {
        
        val EMPTY = User(
            accountId = 0,
            nickname = "이오형ㅋ",
            profileImage = ""
        )
    }
}
