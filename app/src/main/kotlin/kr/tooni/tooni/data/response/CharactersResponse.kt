/*
 * Created by Leo on 2021. 04. 18 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.model.Character

data class CharactersResponse(
    val info: Info,
    val results: List<Character>
) : Response {
    
    data class Info(
        val count: Int?,
        val page: Int?,
        val next: String?,
        val prev: String?
    )
}
