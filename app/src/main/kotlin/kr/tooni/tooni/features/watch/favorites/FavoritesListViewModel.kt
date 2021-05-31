package kr.tooni.tooni.features.watch.favorites

import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.features.watch.favorites.db.FavoritesRepository

class FavoritesListViewModel(private val repository: FavoritesRepository): BaseViewModel() {

    fun updateFavorites() {
        val favorites = mutableListOf<Favorites>()

        for (i in 0 until 30) {
            var favorite = Favorites(
                i,
                "naver",
                "급식아빠 $i",
                listOf(Author(0, "김재한")),
                "",
                9.9,
                listOf("스토리","액션")
            )
            insertFavorites(favorite)
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