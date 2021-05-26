package kr.tooni.tooni.features.watch.favorites.db

import kr.tooni.tooni.features.watch.favorites.Favorites
import kr.tooni.tooni.watch.favorites.db.FavoritesDAO

class FavoritesRepository(private val dao : FavoritesDAO) {

    val favorites = dao.getAllFavorites();

    suspend fun insert(favorite: Favorites) {
        dao.insertFavorites(favorite)
    }

    suspend fun update(favorite: Favorites) {
        dao.updateFavorites(favorite)
    }

    suspend fun delete(favorite: Favorites) {
        dao.deleteFavorites(favorite)
    }

    suspend fun deleteAll() {
        dao.deleteAllFavorites()
    }
}