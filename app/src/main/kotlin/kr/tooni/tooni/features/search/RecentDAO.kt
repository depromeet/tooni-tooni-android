package kr.tooni.tooni.features.search

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import retrofit2.http.DELETE

@Dao
interface RecentDAO {
    @Query("SELECT * FROM tb_recentKeyword")
    fun getAll(): List<RecentEntity>

    // @Query("SELECT * FROM tb_recentKeyword WHERE")

    @Insert
    fun insertAll(vararg recents: RecentEntity)

    @DELETE
    fun delete(recents: RecentEntity)
}