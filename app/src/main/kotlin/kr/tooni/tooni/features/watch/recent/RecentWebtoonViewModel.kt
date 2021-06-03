package kr.tooni.tooni.features.watch.recent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoon
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoonRepository

class RecentWebtoonViewModel(private val repository: RecentWebtoonRepository): ViewModel() {

    fun updateRecentWebtoons() {
        for(i in 1 until 20) {
            var recentWebtoon = RecentWebtoon(
                i,
                Webtoon.EMPTY
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