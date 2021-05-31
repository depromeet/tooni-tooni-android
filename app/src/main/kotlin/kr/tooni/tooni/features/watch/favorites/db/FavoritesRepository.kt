package kr.tooni.tooni.features.watch.favorites.db

import kr.tooni.tooni.features.watch.favorites.Favorites
import kr.tooni.tooni.watch.favorites.db.FavoritesDAO

class FavoritesRepository(private val dao : FavoritesDAO) {

    val favorites = dao.getAllFavorites();

    suspend fun insert(favorite: Favorites): Long {
        return dao.insertFavorites(favorite)
    }

    suspend fun update(favorite: Favorites): Int {
        return dao.updateFavorites(favorite)
    }

    suspend fun delete(favorite: Favorites): Int {
        return dao.deleteFavorites(favorite)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAllFavorites()
    }
}