/*
 * Created by Leo on 2021. 06. 09 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.Banner
import kr.tooni.tooni.core.model.Webtoon

data class HomeResponse(
    val data: Spec
) : BaseResponse() {
    
    data class Spec(
        val mainBanner: List<Banner>, // 상단 배너
        val weekdayWebtoons: List<Webtoon>, // 요일별 웹툰 리스트
        val trendingWebtoons: List<Webtoon>, // 인기급상승 웹툰 리스트
        val genreWebtoons: List<Webtoon>, // 장르별 웹툰 리스트
        val bingeWatchableWebtoons: List<Webtoon> // 몰아보기 좋은 웹툰 리스트
    )
}
