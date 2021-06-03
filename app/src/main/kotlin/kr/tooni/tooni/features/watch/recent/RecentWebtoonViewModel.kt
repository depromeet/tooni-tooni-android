package kr.tooni.tooni.features.watch.recent

import android.widget.Toast
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

    fun updateRecentWebtoons() {
        for(i in 1 until 20) {
            var recentWebtoon = RecentWebtoon(
                i,
                Webtoon(
                    i.toLong(),
                    Site.NAVER,
                    "급식 아빠 ${i}",
                    listOf(Author(0, "최현정"), Author(1, "김재한")),
                    "",
                    5.25555,
                    listOf("스토리", "액션"),
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