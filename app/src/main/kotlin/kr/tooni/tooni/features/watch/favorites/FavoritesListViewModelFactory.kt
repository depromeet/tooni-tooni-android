package kr.tooni.tooni.features.watch.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.tooni.tooni.features.watch.favorites.db.FavoritesRepository

class FavoritesListViewModelFactory (private val repository: FavoritesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FavoritesListViewModel::class.java)) {
            return FavoritesListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unkown View Model Class")
    }
}