/*
 * Created by Leo on 2021. 06. 09 ..
 */
package kr.tooni.tooni.data.response

data class UpsertWebtoonResponse(
    val data: Spec
) : BaseResponse() {
    
    data class Spec(
        val drawingAverage: Double, // 작화점수
        val storyAverage: Double, // 스토리점수
        val totalAverage: Double, // 투니평점
        val votes: Int // 평가인원수
    )
}
