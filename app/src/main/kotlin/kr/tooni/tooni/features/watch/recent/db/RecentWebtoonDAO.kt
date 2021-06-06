package kr.tooni.tooni.features.watch.recent.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RecentWebtoonDAO {

    // Return the row id
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentWebtoon(recentWebtoon: RecentWebtoon): Long

    // Retrun the number of rows that were updated
    @Update
    suspend fun updateRecentWebtoon(recentWebtoon: RecentWebtoon): Int

    // Retrun the number of rows that were deleted
    @Delete
    suspend fun deleteRecentWebtoon(recentWebtoon: RecentWebtoon): Int

    // Retrun the number of rows that were deleted
    @Query("DELETE FROM recent_webtoon_data_table")
    suspend fun deleteAllRecentWebtoon(): Int

    @Query("SELECT * FROM recent_webtoon_data_table")
    fun getAllRecentWebtoons(): Flow<List<RecentWebtoon>>

}