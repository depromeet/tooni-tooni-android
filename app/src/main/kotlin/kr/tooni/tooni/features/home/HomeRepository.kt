/*
 * Created by Leo on 2021. 06. 11 ..
 */
package kr.tooni.tooni.features.home

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.core.model.Banner
import kr.tooni.tooni.core.model.Webtoon

interface HomeRepository {
    fun getMainBanner(): Single<List<Banner>> // 상단 배너
    fun getWeekdayWebtoons(): Single<List<Webtoon>> // 요일별 웹툰 리스트
    fun getTrendingWebtoons(): Single<List<Webtoon>> // 인기급상승 웹툰 리스트
    fun getRecommendAuthors(): Single<List<Author>> // 추천 작가 리스트
    fun getGenreWebtoons(): Single<List<Webtoon>> // 장르별 웹툰 리스트
    fun getBingeWatchableWebtoons(): Single<List<Webtoon>> // 몰아보기 좋은 웹툰 리스트
}
