package kr.tooni.tooni.watch.favorites.db

import androidx.room.*
import kr.tooni.tooni.features.watch.favorites.Favorites

@Dao
interface FavoritesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorites(favorites : Favorites) : Long

    @Update
    suspend fun updateFavorites(favorites: Favorites)

    @Delete
    suspend fun deleteFavorites(favorites: Favorites)

    @Query("DELETE FROM favorites_data_table")
    suspend fun deleteAllFavorites()

    @Query("SELECT * FROM favorites_data_table")
    fun getAllFavorites()

}