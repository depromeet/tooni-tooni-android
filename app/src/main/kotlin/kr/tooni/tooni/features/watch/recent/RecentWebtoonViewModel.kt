package kr.tooni.tooni.features.watch.recent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.core.model.BackgroundColor
import kr.tooni.tooni.core.model.Site
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoon
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoonRepository

class RecentWebtoonViewModel(private val repository: RecentWebtoonRepository): ViewModel() {

    private lateinit var recentWebtoon: RecentWebtoon

    fun updateRecentWebtoons() {
        for(i in 1 until 20) {
            var site = Site.NAVER
            if(i % 3 == 1) site = Site.DAUM
            if(i % 3 == 2) site = Site.KAKAO

            recentWebtoon = RecentWebtoon(
                i,
                Webtoon(
                    i.toLong(),
                    site,
                    "급식 아빠 ${i}",
                    "",
                    listOf(Author(0, "최현정", ""), Author(1, "김재한", "")),
                    "",
                    "",
                    5.25555,
                    listOf("드라마", "순정"),
                    listOf(),
                    BackgroundColor.NONE,
                    false
                )
            )
            insertRecentWebtoon(recentWebtoon)
        }
    }

    private fun insertRecentWebtoon(recentWebtoon: RecentWebtoon) = viewModelScope.launch {
        repository.insert(recentWebtoon)

    }

    fun deleteRecentWebtoon(recentWebtoon: RecentWebtoon) = viewModelScope.launch {
        repository.delete(recentWebtoon)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun getAllRecentWebtoons() = liveData {
        repository.recentWebtoons.collect {
            emit(it)
        }
    }

}
