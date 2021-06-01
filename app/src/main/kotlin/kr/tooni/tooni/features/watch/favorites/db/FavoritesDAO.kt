package kr.tooni.tooni.watch.favorites.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kr.tooni.tooni.features.watch.favorites.db.Favorites

@Dao
interface FavoritesDAO {

    // Return the row id
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorites(favorites : Favorites) : Long

    // Retrun the number of rows that were updated
    @Update
    suspend fun updateFavorites(favorites: Favorites) : Int

    // Retrun the number of rows that were deleted
    @Delete
    suspend fun deleteFavorites(favorites: Favorites) : Int

    // Retrun the number of rows that were deleted
    @Query("DELETE FROM favorites_data_table")
    suspend fun deleteAllFavorites() : Int

    @Query("SELECT * FROM favorites_data_table")
    fun getAllFavorites() : Flow<List<Favorites>>
}