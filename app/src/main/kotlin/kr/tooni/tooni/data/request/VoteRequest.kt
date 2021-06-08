/*
 * Created by Leo on 2021. 06. 09 ..
 */
package kr.tooni.tooni.data.request

data class VoteRequest(
    val accountId: Long,
    val drawingScore: Double,
    val storyScore: Double,
    val webtoonId: Long
) : Request
