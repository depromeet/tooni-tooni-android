package kr.tooni.tooni.features.watch.recent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoonRepository
import java.lang.IllegalArgumentException

class RecentWebtoonViewModelFactory(
    private val repository: RecentWebtoonRepository
    ): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RecentWebtoonViewModel::class.java)) {
            return RecentWebtoonViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}