package kr.tooni.tooni.features.watch.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.core.model.BackgroundColor
import kr.tooni.tooni.core.model.Site
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.features.watch.favorites.db.Favorites
import kr.tooni.tooni.features.watch.favorites.db.FavoritesRepository

class FavoritesListViewModel(private val repository: FavoritesRepository): ViewModel() {

    private lateinit var favorites: Favorites

    fun updateFavorites() {
        for(i in 1 until 20) {
            var site = Site.NAVER
            if(i % 3 == 1) site = Site.DAUM
            if(i % 3 == 2) site = Site.KAKAO

            favorites = Favorites(
                i,
                Webtoon(
                    i.toLong(),
                    site,
                    "급식 아빠 ${i}",
                    "",
                    listOf(Author(0, "최현정")),
                    "",
                    "",
                    7.18888888,
                    listOf("드라마", "순정"),
                    listOf(),
                    BackgroundColor.NONE,
                    false
                )
            )
            insertFavorites(favorites)
        }
    }

    private fun insertFavorites(favorites: Favorites) = viewModelScope.launch {
        repository.insert(favorites)
    }

    fun delete(favorites: Favorites) = viewModelScope.launch {
        repository.delete(favorites)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun getSavedFavorites() = liveData {
        repository.favorites.collect {
            emit(it)
        }
    }
}